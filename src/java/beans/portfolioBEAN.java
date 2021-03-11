/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import ejb.UserBeanLocal;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import clients.portfolioCLIENT;
import ejb.AdminBeanLocal;
import entity.Photocategory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.core.*;
import org.primefaces.PrimeFaces;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author KALP
 */
@Named(value = "portfolioBEAN")
@ViewScoped
public class portfolioBEAN implements Serializable {

    /**
     * Creates a new instance of portfolioBEAN
     */
    public portfolioBEAN() {
    }

    @Inject
    ServletContext context;
    @EJB
    UserBeanLocal ubl;
    @EJB
    AdminBeanLocal abl;
    portfolioCLIENT portclient = new portfolioCLIENT();

    Photocategory photocategory;
    UploadedFile file;
    int categoryId;
    String CategoryName, Description, CategoryPhotoPath, tempphotouri;
    private Collection<Photocategory> portlist;

    public Collection<Photocategory> getPortlist() {
        Response response = portclient.getAllPhotoCategory(Response.class);
        ArrayList<Photocategory> photocategorys = new ArrayList<Photocategory>();
        GenericType<Collection<Photocategory>> genericType = new GenericType<Collection<Photocategory>>() {
        };
        photocategorys = (ArrayList<Photocategory>) response.readEntity(genericType);
        portlist = photocategorys;
//        for (Photocategory photocategory1 : photocategorys) {
//            System.out.println("Name : " + photocategory1.getCategoryName());
//        }
        return portlist;
    }

    public void setPortlist(Collection<Photocategory> portlist) {
        this.portlist = portlist;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCategoryPhotoPath() {
        return CategoryPhotoPath;
    }

    public void setCategoryPhotoPath(String CategoryPhotoPath) {
        this.CategoryPhotoPath = CategoryPhotoPath;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getTempphotouri() {
        return tempphotouri;
    }

    public void setTempphotouri(String tempphotouri) {
        this.tempphotouri = tempphotouri;
    }

    public Photocategory getPhotocategory() {
        return photocategory;
    }

    public void setPhotocategory(Photocategory photocategory) {
        this.photocategory = photocategory;
    }

    public Collection<Photocategory> getallPhotoCategoryName() {
        System.out.println("in col");
        return ubl.getAllPhotoCategoryName();
    }

    public String addPhotoCategory() throws IOException {
        System.out.println(file.getFileName());
        try (InputStream i = file.getInputStream()) {
            
            System.out.println("in add");
            Photocategory photocategory = new Photocategory();
            String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\Category";
            CategoryPhotoPath = file.getFileName();
            Files.copy(i, new File(path, CategoryPhotoPath).toPath());
            photocategory.setCategoryId(categoryId);
            photocategory.setCategoryName(CategoryName);
            photocategory.setDescription(Description);
            System.out.println("Category Id = " + categoryId + " , Category Name = " + CategoryName + " , Category Path = " + CategoryPhotoPath);
            portclient.addPhotoCategory(CategoryName, Description, CategoryPhotoPath);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "photocategory.xhtml?faces-redirect=true";
    }

    public void getPhotoCategoryById(int categoryId) {
        Response response = portclient.getPhotoCategoryById(Response.class, categoryId);
        GenericType<Photocategory> genericType = new GenericType<Photocategory>() {
        };
        Photocategory photocategory = response.readEntity(genericType);
        this.categoryId = photocategory.getCategoryId();
        CategoryName = photocategory.getCategoryName();
        Description = photocategory.getDescription();
        CategoryPhotoPath = photocategory.getCategoryPhotoPath();

        System.out.println(CategoryPhotoPath);
    }

    public void updatePhotoCategory() {
        System.out.println(file.getFileName());
        if (file.getFileName() == null) {
            System.out.println("in without file update");
            System.out.println("without file selects and goes to update");
            System.out.println("Category Id = " + categoryId + " , Category Name = " + CategoryName + " , Category Path = " + CategoryPhotoPath);
            portclient.updatePhotoCategory(categoryId, CategoryName, Description, CategoryPhotoPath);
            getPortlist();
        } else {
            try (InputStream i = file.getInputStream()) {
                System.out.println("in add");
                Photocategory photocategory = new Photocategory();
                String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\Category";
                CategoryPhotoPath = file.getFileName();
                Files.copy(i, new File(path, CategoryPhotoPath).toPath());
                photocategory.setCategoryId(categoryId);
                photocategory.setCategoryName(CategoryName);
                photocategory.setDescription(Description);
                System.out.println("Category Id = " + categoryId + " , Category Name = " + CategoryName + " , Category Path = " + CategoryPhotoPath);
                portclient.updatePhotoCategory(categoryId, CategoryName, Description, CategoryPhotoPath);
                getPortlist();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void deletephotocategory(int catId) {
        portclient.deletePhotoCategory(Response.class,catId);
        getPortlist();
    }

    public void GoToAllPhotos(int CategoryId) throws IOException {
//        return "allphotos.xhtml?faces-redirect=true?CategoryName="+CategoryName;
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        Object request = context.getRequest();
        Object response = context.getResponse();

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (session.getAttribute("User") == null) {
            res.sendRedirect(".../Login.xhtml");
        }
        if (session.getAttribute("User") != null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("allphotos.xhtml?CategoryId=" + CategoryId);
        }
    }

    public void reset(CloseEvent e) {

        System.out.println("in reset function");
        setCategoryId(0);
        setCategoryName("");
        setCategoryPhotoPath("");
        setDescription("");
    }

}
