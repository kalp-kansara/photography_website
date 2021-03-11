/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clients.photographerofweekCLIENT;
import entity.Contest;
import entity.Imageofweek;
import entity.Photocategory;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.eclipse.persistence.descriptors.SerializableDescriptorEventHolder;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author KALP
 */
@Named(value = "photographeroftheweekBean")
@ViewScoped
public class photographeroftheweekBean implements Serializable{

    
    public photographeroftheweekBean() {
    }
    
    UploadedFile file;
    int ImageoftheWeekId;
    String ImageOfWeekPhotoPath,ImageDescription,SocialProfileUrl,SocialPhotoUrl;
    Date DeclarationDate;
    Collection<Imageofweek> list;

    photographerofweekCLIENT pClient = new photographerofweekCLIENT();
    
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public int getImageoftheWeekId() {
        return ImageoftheWeekId;
    }

    public void setImageoftheWeekId(int ImageoftheWeekId) {
        this.ImageoftheWeekId = ImageoftheWeekId;
    }

    public String getImageOfWeekPhotoPath() {
        return ImageOfWeekPhotoPath;
    }

    public void setImageOfWeekPhotoPath(String ImageOfWeekPhotoPath) {
        this.ImageOfWeekPhotoPath = ImageOfWeekPhotoPath;
    }

    public String getImageDescription() {
        return ImageDescription;
    }

    public void setImageDescription(String ImageDescription) {
        this.ImageDescription = ImageDescription;
    }

    public String getSocialProfileUrl() {
        return SocialProfileUrl;
    }

    public void setSocialProfileUrl(String SocialProfileUrl) {
        this.SocialProfileUrl = SocialProfileUrl;
    }

    public String getSocialPhotoUrl() {
        return SocialPhotoUrl;
    }

    public void setSocialPhotoUrl(String SocialPhotoUrl) {
        this.SocialPhotoUrl = SocialPhotoUrl;
    }

    public Date getDeclarationDate() {
        return DeclarationDate;
    }

    public void setDeclarationDate(Date DeclarationDate) {
        this.DeclarationDate = DeclarationDate;
    }

    public Collection<Imageofweek> getImageofweek() {
        return list;
    }

    public void setImageofweek(Collection<Imageofweek> list) {
        this.list = list;
    }
    
    public Collection<Imageofweek> getAllImageoftheweekData()
    {
        
        Response response = pClient.getAllImageOfWeekData(Response.class);
        ArrayList<Imageofweek> arrayList;
        GenericType<Collection<Imageofweek>> genericType = new GenericType<Collection<Imageofweek>>() {
        };
        arrayList = (ArrayList<Imageofweek>) response.readEntity(genericType);
        
        return arrayList;
    }
    
    public String addImageOftheWeek()
    {
        LocalDate decldate  = java.time.LocalDate.now();
        try (InputStream i = file.getInputStream())
        {
            String path = "E://Mcs(IT)//8th sem//JAVA EE//Project//web proect//photographyProject//web//User//Upload//ImageOfWeek";
            ImageOfWeekPhotoPath = file.getFileName();
            Files.copy(i, new File(path, ImageOfWeekPhotoPath).toPath());
            
            System.out.println(java.time.LocalDate.now());
            pClient.AddImageOfTheWeek(ImageOfWeekPhotoPath, SocialProfileUrl, SocialPhotoUrl,ImageDescription, decldate.toString());
                    
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return "photographeroftheweek.xhtml?faces-redirect=true";
    }
    
    public void getImageofweekById(int imageofweekId) throws ParseException
    {
        Response response = pClient.getAllImageOfWeekDataById(Response.class, imageofweekId);
        
        GenericType<Imageofweek> genericType = new GenericType<Imageofweek>() {
        };
        
        Imageofweek imageofweek = response.readEntity(genericType);
        this.ImageoftheWeekId = imageofweek.getImageOfWeekId();
        ImageOfWeekPhotoPath = imageofweek.getImageOfWeekPhotoPath();
        SocialProfileUrl = imageofweek.getSocialProfileUrl();
        SocialPhotoUrl = imageofweek.getSocialPhotoUrl();
        ImageDescription = imageofweek.getImageDescription();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String decldate = imageofweek.getDeclarationDate();
        Date decdate = sd.parse(decldate);
        DeclarationDate = decdate;
        
    }
    
    public void UpdateImageOfWeek()
    {
        System.out.println("in update bean");
        System.out.println(ImageOfWeekPhotoPath);
        LocalDate decldate  = java.time.LocalDate.now();
        
        if (file.getFileName() == null) {
            pClient.UpdateImageOfTheWeek(ImageoftheWeekId, ImageOfWeekPhotoPath, SocialProfileUrl, SocialPhotoUrl, ImageDescription, DeclarationDate.toString());
            getAllImageoftheweekData();
        } else {
            try (InputStream i = file.getInputStream()) 
            {
                System.out.println("in add");
                Imageofweek imageofweek = new Imageofweek();
                String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\Category";
                ImageOfWeekPhotoPath = file.getFileName();
                Files.copy(i, new File(path, ImageOfWeekPhotoPath).toPath());
                imageofweek.setImageOfWeekId(ImageoftheWeekId);
                imageofweek.setSocialProfileUrl(SocialProfileUrl);
                imageofweek.setSocialPhotoUrl(SocialPhotoUrl);
                imageofweek.setImageDescription(ImageDescription);
                imageofweek.setDeclarationDate(SocialPhotoUrl);
                pClient.UpdateImageOfTheWeek(ImageoftheWeekId, ImageOfWeekPhotoPath, SocialProfileUrl, SocialPhotoUrl, ImageDescription, DeclarationDate.toString());
                getAllImageoftheweekData();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        
    }
    
    public void deleteImageOfWeek(int photographerOfWeekId)
    {
        pClient.DeleteImageOfWeekDataById(Response.class, photographerOfWeekId);
        getAllImageoftheweekData();
    }
    
    public void reset()
    {
        setDeclarationDate(null);
        setImageDescription("");
        setImageoftheWeekId(0);
        setSocialPhotoUrl("");
        setSocialProfileUrl("");
    }
}
