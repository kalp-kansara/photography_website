/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clients.useruploadphotoCLIENT;
import ejb.UserBeanLocal;
import entity.Photocategory;
import entity.Useruploadphoto;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.ws.rs.core.*;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author KALP
 */
@Named(value = "useruploadphotoBEAN")
@ViewScoped
public class useruploadphotoBEAN implements Serializable{

    @EJB
    UserBeanLocal ubl;
    private StreamedContent file;
    useruploadphotoCLIENT uupclient = new useruploadphotoCLIENT();
    int id;
    int UserUploadPhotoId, Userid, Categoryid;
    String PhotoDecription, PhotoPathOriginal, CategoryName;
    Boolean IsApprove;
    Collection<Useruploadphoto> list;
    
    

    /**
     * Creates a new instance of useruploadphotoBEAN
     */
    public useruploadphotoBEAN() {
        
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
    
    

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public int getUserUploadPhotoId() {
        return UserUploadPhotoId;
    }

    public void setUserUploadPhotoId(int UserUploadPhotoId) {
        this.UserUploadPhotoId = UserUploadPhotoId;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int Userid) {
        this.Userid = Userid;
    }

    public int getCategoryid() {
        return Categoryid;
    }

    public void setCategoryid(int Categoryid) {
        this.Categoryid = Categoryid;
    }

    public String getPhotoDecription() {
        return PhotoDecription;
    }

    public void setPhotoDecription(String PhotoDecription) {
        this.PhotoDecription = PhotoDecription;
    }

    public String getPhotoPathOriginal() {
        return PhotoPathOriginal;
    }

    public void setPhotoPathOriginal(String PhotoPathOriginal) {
        this.PhotoPathOriginal = PhotoPathOriginal;
    }

    public Boolean getIsApprove() {
        return IsApprove;
    }

    public void setIsApprove(Boolean IsApprove) {
        this.IsApprove = IsApprove;
    }

    public Collection<Useruploadphoto> getList() {
        return list;
    }

    public void setList(Collection<Useruploadphoto> list) {
        this.list = list;
    }

    
    
    
    public Collection<Useruploadphoto> getallusersphoto() {
        return ubl.showAllUploadedPhoto();
    }
   
    public Collection<Useruploadphoto> getuserphotosByCategoryId(int categoryid)
    {
        return ubl.showAllUploadedPhototCatId(categoryid);
    }
    
//    public void download(String photoPathOriginal)
//    {
//        file = DefaultStreamedContent.builder()
//                .name("downloaded_"+photoPathOriginal)
//                .contentType("image/jpg")
//                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/Upload/AllUserPhotos/"+photoPathOriginal))
//                .build();
//    }
    
    public void redirect() throws IOException
    {
         Map<String, String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.Categoryid = Integer.parseInt(param.get("id"));
        System.out.println(Categoryid);
        FacesContext.getCurrentInstance().getExternalContext().redirect("allphotos.xhtml?id=" + Categoryid);
    }
    
//    public String redirect()
//    {
//        return "allphotos?backurl=actionUrl&CategoryId = actionId&faces-redirect=true";
//    }
    

//        @PostConstruct
//        public void init()
//        {
//                list=new ArrayList<Useruploadphoto>();
//        }
//    request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
}
