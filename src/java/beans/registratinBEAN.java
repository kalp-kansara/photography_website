/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clients.registrationCLIENT;
import ejb.UserBeanLocal;
import entity.Users;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author KALP
 */
@Named(value = "registrationBEAN")
@ApplicationScoped
public class registratinBEAN {

    int UserId;
    String EmailId,Password,FirstName,MiddleName,LastName,ProfilePhoto,UserProfileURL;
    Boolean IsDisable = Boolean.FALSE;
    Part file;
    
    @EJB UserBeanLocal ubl;
//    registrationCLIENT rclient = new registrationCLIENT();
    
        public registratinBEAN() {
//        System.out.println("Hello registrationCDI Bean ");
//        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        String token = "";
//
//        token = request.getSession().getAttribute("token").toString();
//        System.out.println("Token=" + token);
//        registrationCLIENT regiCLIENT = new registrationCLIENT(token);

        // brc = new BookRestClient(username, password);
//        books = new ArrayList<BookMaster>();
//        gbooks = new GenericType<Collection<BookMaster>>() {
//        };

    }


    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getProfilePhoto() {
        return ProfilePhoto;
    }

    public void setProfilePhoto(String ProfilePhoto) {
        this.ProfilePhoto = ProfilePhoto;
    }

    public String getUserProfileURL() {
        return UserProfileURL;
    }

    public void setUserProfileURL(String UserProfileURL) {
        this.UserProfileURL = UserProfileURL;
    }

    public Boolean getIsDisable() {
        return IsDisable;
    }

    public void setIsDisable(Boolean IsDisable) {
        this.IsDisable = IsDisable;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    
    public String registration()
    {
//        try
//        {
//            InputStream inputStream = file.getInputStream();
////            String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\Project\\Project-war\\web\\User\\Upload\\Users";
//            Random random = new Random();
//            StringBuilder sb = new StringBuilder();
//            
//              sb.append(random.nextInt(9) + 1 );
//            for (int i = 0; i < 11; i++) {
//                sb.append(random.nextInt(10));
//            }
//            String temp = sb.toString();
//            ProfilePhoto = temp + file.getSubmittedFileName();
//            Files.copy(inputStream,new File(path,ProfilePhoto).toPath());
//            
//            Users users = new Users();
//            
//            users.setUserId(0);
//            users.setEmailId(EmailId);
//            users.setPassword(Password);
//            users.setFirstName(FirstName);
//            users.setMiddleName(MiddleName);
//            users.setLastName(LastName);
//            users.setProfilePhoto(ProfilePhoto);
//            users.setIsDisable(false);
//            
//            ubl.Registration(EmailId, Password, FirstName, MiddleName, LastName, ProfilePhoto, UserProfileURL, IsDisable);
//            
//        }catch(Exception e)
//        {  
//            e.printStackTrace();
//        }
        String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\Users";
        try(InputStream i = file.getInputStream()){
            ProfilePhoto = file.getSubmittedFileName();
            Files.copy(i, new File(path,ProfilePhoto).toPath());
            
            Users users = new Users();
            
            users.setUserId(UserId);
            users.setEmailId(EmailId);
            users.setPassword(Password);
            users.setFirstName(FirstName);
            users.setMiddleName(MiddleName);
            users.setLastName(LastName);
            users.setProfilePhoto(ProfilePhoto);
            users.setIsDisable(IsDisable);
            
            ubl.Registration(EmailId, Password, FirstName, MiddleName, LastName, ProfilePhoto, UserProfileURL, IsDisable);
            
        }catch(Exception e){
            e.printStackTrace();
        }

//        rclient.RegistrationUser(EmailId, Password, FirstName, MiddleName, LastName, ProfilePhoto, FirstName);
        return "Login.xhtml?faces-redirect=true";
   }
    
    
}
