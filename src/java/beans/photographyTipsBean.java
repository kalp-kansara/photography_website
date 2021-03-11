/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clients.photographyTipsCLIENT;
import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Photographytips;
import entity.Tipstype;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author KALP
 */
@Named(value = "photographyTipsBean")
@ViewScoped
public class photographyTipsBean implements Serializable{
    
    @EJB AdminBeanLocal abl;
    @EJB UserBeanLocal ubl;

    int photographyTipsId,TipsTypeId;
    String photographyTipsPhotoPath,PhotographyTipsDescription;
    UploadedFile file;
    private Collection<Photographytips> plist;
    photographyTipsCLIENT pClient = new photographyTipsCLIENT();
    
    public photographyTipsBean() {
    }

    public int getPhotographyTipsId() {
        return photographyTipsId;
    }

    public void setPhotographyTipsId(int photographyTipsId) {
        this.photographyTipsId = photographyTipsId;
    }

    public int getTipsTypeId() {
        return TipsTypeId;
    }

    public void setTipsTypeId(int TipsTypeId) {
        this.TipsTypeId = TipsTypeId;
    }

    public String getPhotographyTipsPhotoPath() {
        return photographyTipsPhotoPath;
    }

    public void setPhotographyTipsPhotoPath(String photographyTipsPhotoPath) {
        this.photographyTipsPhotoPath = photographyTipsPhotoPath;
    }

    public String getPhotographyTipsDescription() {
        return PhotographyTipsDescription;
    }

    public void setPhotographyTipsDescription(String PhotographyTipsDescription) {
        this.PhotographyTipsDescription = PhotographyTipsDescription;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Collection<Photographytips> getPlist() {
        return plist;
    }

    public void setPlist(Collection<Photographytips> plist) {
        this.plist = plist;
    }
    
    public Collection<Photographytips> getAllTipsbyid(int tipsTypeId) {
//         Response response = pClient.getAllPhotographyTips(Response.class);
//        ArrayList<Photographytips> arrayList;
//        GenericType<Collection<Photographytips>> genericType = new GenericType<Collection<Photographytips>>() {
//        };
//        arrayList = (ArrayList<Photographytips>) response.readEntity(genericType);
//
//        return arrayList;
        return ubl.ShowAllPhotographyTipsById(tipsTypeId);
    }
    
    public String AddPhotographyTips()
    {
//        System.out.println(file.getFileName());
        try (InputStream i = file.getInputStream()) {
            String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\photographyTips";
            photographyTipsPhotoPath = file.getFileName();
            Files.copy(i, new File(path, photographyTipsPhotoPath).toPath());
            pClient.addPhotographyTips(TipsTypeId, photographyTipsPhotoPath, PhotographyTipsDescription);
         } catch (Exception e) {
            System.out.println(e);
        }
        return "tipstype.xhtml?faces-redirect=true&id="+TipsTypeId;
    }
    
    public void redirect() throws IOException
    {
         Map<String, String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.TipsTypeId = Integer.parseInt(param.get("id"));
        System.out.println(TipsTypeId);
        FacesContext.getCurrentInstance().getExternalContext().redirect("tipstype.xhtml?id=" + TipsTypeId);
    }
}
