/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clients.TipsCLIENT;
import clients.portfolioCLIENT;
import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Imageofweek;
import entity.Photocategory;
import entity.Tipstype;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.model.file.UploadedFile;

@Named(value = "tipsBean")
@ViewScoped
public class TipsBean implements Serializable{

    @Inject
    ServletContext context;
    @EJB
    UserBeanLocal ubl;
    @EJB
    AdminBeanLocal abl;
    TipsCLIENT tClient = new TipsCLIENT();

    public TipsBean() {
    }

    int TipsTypeId;
    String TipsTypeName, TipsTypeDescription, TipsTypePhotoPath;
    UploadedFile file;
    private Collection<Tipstype> TipsList;

    public TipsCLIENT gettClient() {
        return tClient;
    }

    public void settClient(TipsCLIENT tClient) {
        this.tClient = tClient;
    }

    public int getTipsTypeId() {
        return TipsTypeId;
    }

    public void setTipsTypeId(int TipsTypeId) {
        this.TipsTypeId = TipsTypeId;
    }

    public String getTipsTypeName() {
        return TipsTypeName;
    }

    public void setTipsTypeName(String TipsTypeName) {
        this.TipsTypeName = TipsTypeName;
    }

    public String getTipsTypeDescription() {
        return TipsTypeDescription;
    }

    public void setTipsTypeDescription(String TipsTypeDescription) {
        this.TipsTypeDescription = TipsTypeDescription;
    }

    public String getTipsTypePhotoPath() {
        return TipsTypePhotoPath;
    }

    public void setTipsTypePhotoPath(String TipsTypePhotoPath) {
        this.TipsTypePhotoPath = TipsTypePhotoPath;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Collection<Tipstype> getTipsList() {
        return TipsList;
    }

    public void setTipsList(Collection<Tipstype> TipsList) {
        this.TipsList = TipsList;
    }

    public Collection<Tipstype> getAllTipsType() {
        Response response = tClient.getAllTips(Response.class);
        ArrayList<Tipstype> arrayList;
        GenericType<Collection<Tipstype>> genericType = new GenericType<Collection<Tipstype>>() {
        };
        arrayList = (ArrayList<Tipstype>) response.readEntity(genericType);

        return arrayList;
    }

    public String AddTipsType() {
        try (InputStream i = file.getInputStream()) {
            String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\Tips";
            TipsTypePhotoPath = file.getFileName();
            Files.copy(i, new File(path, TipsTypePhotoPath).toPath());
            tClient.AddTipsType(TipsTypeName, TipsTypeDescription, TipsTypePhotoPath);
        } catch (Exception e) {
        }
        return "tips.xhtml?faces-redirect=true";
    }

    public void getTipsTypeById(int TipsTypeId) {
//        Response response = tClient.getTipsTypeById(Response.class, TipsTypeId);
//        GenericType<Tipstype> genericType = new GenericType<Tipstype>() {
//        };
//        Tipstype t = response.readEntity(genericType);
        Tipstype t = abl.getTipsTypeById(TipsTypeId);
        this.TipsTypeId = t.getTipsTypeId();
        TipsTypeName = t.getTipsTypeName();
        TipsTypeDescription = t.getTipsTypeDescription();
        TipsTypePhotoPath = t.getTipsTypePhotoPath();
    }

    public void updateTipsType() {
        System.out.println(file.getFileName());
        if (file.getFileName() == null) {
            tClient.UpdateTipsType(TipsTypeId, TipsTypeName, TipsTypeDescription, TipsTypePhotoPath);
            getAllTipsType();
        } else {
            try (InputStream i = file.getInputStream()) {
                String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\Tips";
                TipsTypePhotoPath = file.getFileName();
                Files.copy(i, new File(path, TipsTypePhotoPath).toPath());
                tClient.UpdateTipsType(TipsTypeId, TipsTypeName, TipsTypeDescription, TipsTypePhotoPath);
                getAllTipsType();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void DeleteTipsType(int TipsTypeId)
    {
        tClient.deleteTipsType(Response.class, TipsTypeId);
        getAllTipsType();
    }
    
    public void reset()
    {
        setTipsTypeId(0);
        setTipsTypeName("");
        setTipsTypeDescription("");
        setTipsTypePhotoPath("");
    }
    
    public void redirect(int TipsTypeId) throws IOException
    {
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("tipstype.xhtml?id="+TipsTypeId);
    }
}
