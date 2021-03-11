/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author KALP
 */
@Stateless
public class UserBean implements UserBeanLocal {

    @PersistenceContext(unitName = "ProjectPU")
    EntityManager em;
//    @PostConstruct
//    public void init()
//    {
//        em = Persistence.createEntityManagerFactory("ProjectPU").createEntityManager();
//    }

//    ---------------------------------------Users :--------------------------------------------
    
    
    @Override
    public void Registration(String EmailId, String Password, String FirstName, String MiddleName, String LastName, String Profilephoto, String UserProfileUrl, Boolean IsDisable) {
        Users users = new Users();
        users.setUserId(0);
        users.setEmailId(EmailId);
        String pass = getEncryptedPassword(Password);
        users.setPassword(pass);
        users.setFirstName(FirstName);
        users.setMiddleName(MiddleName);
        users.setLastName(LastName);
        users.setProfilePhoto(Profilephoto);
        users.setSocialProfileURL(UserProfileUrl);
        users.setIsDisable(IsDisable);
//        em.getTransaction().begin();
        em.persist(users);
        
        em.flush();
        int userId = users.getUserId();
        Userrole userrole = new Userrole();
        userrole.setUserId(new Users(userId));
        userrole.setRoleId(new Roles(2));
        em.persist(userrole);
//        em.getTransaction().commit();
    }
   
        public String getEncryptedPassword(String password)
        {
            String encrypedPassword;
            Pbkdf2PasswordHashImpl encPass=new Pbkdf2PasswordHashImpl();
            encrypedPassword = encPass.generate(password.toCharArray());
            return encrypedPassword;
        }
    
    @Override
    public void UpdateProfile(int UserId ,String EmailId , String Password , String FirstName , String MiddleName , String LastName , String MobileNumber , String Profilephoto , String UserProfileUrl , Boolean IsDisable) 
    {
        Users u1 = em.find(Users.class, UserId);
        
        u1.setEmailId(EmailId);
        u1.setPassword(Password);
        u1.setFirstName(FirstName);
        u1.setMiddleName(MiddleName);
        u1.setLastName(LastName);
        //u1.setMobileNumber(MobileNumber);
        u1.setProfilePhoto(Profilephoto);
        u1.setSocialProfileURL(UserProfileUrl);
        u1.setIsDisable(IsDisable);
        em.getTransaction().begin();
        em.merge(u1);
        em.getTransaction().commit();
    }

    
//    ---------------------------------------PhotoCategory :--------------------------------------------
    
    @Override
    public Collection<Photocategory> getAllPhotoCategory() 
    {
        Collection<Photocategory> temp = em.createNamedQuery("Photocategory.findAll").getResultList();
        for (Photocategory photocategory : temp) {
            System.out.println(photocategory.getCategoryName());
        }
        return em.createNamedQuery("Photocategory.findAll").getResultList();
    }
    
    @Override
    public Collection<Photocategory> getAllPhotoCategoryName()
    {
        Collection<Photocategory> temp = em.createNamedQuery("Photocategory.findByCategoryName").getResultList();
        for (Photocategory photocategory : temp) {
            System.out.println(photocategory.getCategoryName());
        }
        return em.createNamedQuery("Photocategory.findByCategoryName").getResultList();
    }
    
  
    
//    ---------------------------------------UserUploadPhoto :--------------------------------------------
    
    @Override
    public Collection<Useruploadphoto> showAllUploadedPhoto() 
    {
        return em.createNamedQuery("Useruploadphoto.findAll").getResultList();
    }
    
    @Override
    public void addUserUploadPhoto(int UserId , int CategoryId , String PhotoDescription , String PhotoPathOriginal, String PhotoPathWM , Boolean IsApprove) {
        Useruploadphoto useruploadphoto = new Useruploadphoto();
        
        Users uid = em.find(Users.class, UserId);
        Photocategory pcid = em.find(Photocategory.class, CategoryId);
        
//        Collection<Useruploadphoto> useruploadphotosforuid  = uid.getUseruploadphotoCollection();
        Collection<Useruploadphoto> useruploadphotosforcid = pcid.getUseruploadphotoCollection();
        
        useruploadphoto.setUserId(uid);
        useruploadphoto.setCategoryId(pcid);
        useruploadphoto.setPhotoDescription(PhotoDescription);
        useruploadphoto.setPhotoPathOriginal(PhotoPathOriginal);
        useruploadphoto.setPhotoPathwithWM(PhotoPathWM);
        useruploadphoto.setIsApprove(false);
        
//        useruploadphotosforuid.add(useruploadphoto);
        useruploadphotosforcid.add(useruploadphoto);
//        em.getTransaction().begin();
        em.merge(uid);
        em.merge(pcid);
        
        
        em.persist(useruploadphoto);
//        em.getTransaction().commit();
    }

    @Override
    public void updateUserUploadPhoto(int UserUploadPhotoId , int UserId , int CategoryId , String PhotoDescription , String PhotoPathOriginal, String PhotoPathWM, Boolean IsApprove) {
         Useruploadphoto useruploadphoto = new Useruploadphoto();
        
        Users uid = em.find(Users.class, UserId);
        Photocategory pcid = em.find(Photocategory.class, CategoryId);
        
//        Collection<Useruploadphoto> useruploadphotosforuid  = uid.getUseruploadphotoCollection();
        Collection<Useruploadphoto> useruploadphotosforcid = pcid.getUseruploadphotoCollection();
        
        useruploadphoto.setUserId(uid);
        useruploadphoto.setCategoryId(pcid);
        useruploadphoto.setPhotoDescription(PhotoDescription);
        useruploadphoto.setPhotoPathOriginal(PhotoPathOriginal);
        useruploadphoto.setPhotoPathwithWM(PhotoPathWM);
        useruploadphoto.setIsApprove(false);
        
//        useruploadphotosforuid.add(useruploadphoto);
        useruploadphotosforcid.add(useruploadphoto);
        em.getTransaction().begin();
        em.merge(uid);
        em.merge(pcid);

        em.merge(useruploadphoto);
        em.getTransaction().commit();
    }

    @Override
    public void deleteUserUploadPhoto(int UserUploadPhotoId) {
        Useruploadphoto useruploadphoto = em.find(Useruploadphoto.class, UserUploadPhotoId);
        em.getTransaction().begin();
        em.remove(useruploadphoto);
        em.getTransaction().commit();
    }
    
    @Override
    public Collection<Useruploadphoto> showAllUploadedPhototCatId(int CategoryId)
    {
        System.out.println("in bean");
//        String sql = "SELECT u.UserUploadPhotoId,u.CategoryId,u.PhotoDescription,u.PhotoPathOriginal FROM useruploadphoto u,photocategory p WHERE p.CategoryId = u.CategoryId and u.CategoryId = "+CategoryId ;
//        return em.createNamedQuery("Useruploadphoto.findByCateId").setParameter("CategoryId",CategoryId).getResultList();
            Collection<Useruploadphoto> temp=em.createQuery("select Userupload from Useruploadphoto Userupload where Userupload.categoryId.categoryId = :CategoryId").setParameter("CategoryId",CategoryId).getResultList();
            for(Useruploadphoto obj:temp){
                System.out.println(obj.getPhotoDescription());
            }
        return em.createQuery("select Userupload from Useruploadphoto Userupload where Userupload.categoryId.categoryId = :CategoryId").setParameter("CategoryId",CategoryId).getResultList();
    }
    
    
    //SEARCH QUERY
    @Override
    public List<Object[]>  ShowPhotoCategorVise(int CategoryId)
    {
        String sql = "SELECT u.UserUploadPhotoId,u.CategoryId,u.PhotoDescription,u.PhotoPathOriginal FROM useruploadphoto u,photocategory p WHERE p.CategoryId = u.CategoryId and u.CategoryId = "+CategoryId ;
        return em.createNativeQuery(sql).getResultList();
    }

    
    
    
    //    ---------------------------------------Plans :--------------------------------------------
    
    @Override
    public Collection showAllPlans() 
    {
        return em.createNamedQuery("Plans.findAll").getResultList();
    }
    
    
    
    //    ---------------------------------------PlansXUser :--------------------------------------------
    
    @Override
    public void choosePlans(int PlansId , int UserId) 
    {
        Plansxuser plansxuser = new Plansxuser();
        
        Users uid = em.find(Users.class, UserId);
        Plans pid = em.find(Plans.class, PlansId);
        
//        Collection<Plansxuser> plansxusersforuid = uid.getPlansxuserCollection();
        Collection<Plansxuser> plansxusersforpid = pid.getPlansxuserCollection();
        
        plansxuser.setPlansId(new Plans(PlansId));
        plansxuser.setUserId(new Users(UserId));
        
//        plansxusersforuid.add(plansxuser);
        plansxusersforpid.add(plansxuser);
        
        em.getTransaction().begin();
        em.merge(uid);
        em.merge(pid);
        em.persist(plansxuser);
        em.getTransaction().commit();
    }


    
    //    ---------------------------------------Payment :--------------------------------------------    
    @Override
    public Collection<Payment> showAllPaymentType() 
    {
        return em.createNamedQuery("Payment.findAll").getResultList();
    }
    
    
    
    
//    ---------------------------------------Contest :--------------------------------------------
    
    @Override
    public Collection<Contest> showAllContest() 
    {
        return em.createNamedQuery("Contest.findAll").getResultList();
    }
    
    @Override
    public Collection<Contest> getContestbyStatus(String Status)
    {
        return em.createNamedQuery("Contest.findByStatus").setParameter("status", Status).getResultList();
    }
    
    @Override
    public Collection<Contest> getContestbyStatusAndContestType(String Status,String ContestType)
    {
        return em.createNamedQuery("Contest.findByContestStatusAndContestType").setParameter("Status", Status).setParameter("ContestType", ContestType).getResultList();
    }
    
    @Override
    public Collection<Contest> getContestbyContestType(String ContestType)
    {
        return em.createNamedQuery("Contest.findByContestType").setParameter("contestType", ContestType).getResultList();
    }
    
//    SearchQuery
    
    @Override
    public List<Object[]> getContestByStatus(String Status)
    {
        String sql = "SELECT  ContestName,Status,ContestType,ContestDescription FROM contest WHERE Status = '"+Status+"' ";
        return em.createNativeQuery(sql).getResultList();
    }
    
    @Override
    public List<Object[]> getContestByActive(Boolean IsActive)
    {
        String sql = "SELECT  ContestName,Status,ContestType,ContestDescription FROM contest WHERE IsActive = '"+IsActive+"' ";
        return em.createNativeQuery(sql).getResultList();
    }
    
     @Override
    public List<Object[]> getContestByContestType(String ContestType)
    {
        String sql = "SELECT ContestName,Status,ContestType,ContestDescription FROM contest WHERE ContestType = '"+ContestType+"' ' ";
        return em.createNativeQuery(sql).getResultList();
    }
    
    
//    ---------------------------------------ContestXUser :--------------------------------------------    
    
    @Override
    public void RegistrationInContest(int ContestId , int UserId , String ContestImage , Date UploadDateTime , String SocialSitePhotoUrl) {
//        Contestxuser contestxuser = new Contestxuser();
//        
//        Contest contestid = em.find(Contest.class, ContestId);
//        Users userid = em.find(Users.class, UserId);
//        
//        Collection<Contestxuser> contestxusersforcontestid = contestid.getContestxuserCollection();
////        Collection<Contestxuser> contestxusersforuserid = userid.getContestxuserCollection();
//        
//        contestxuser.setContestId(new Contest(ContestId));
//        contestxuser.setUserId(new Users(UserId));
//        contestxuser.setContestImagePath(ContestImage);
//        contestxuser.setUploadDateTime(new Date());
//        
//        contestxusersforcontestid.add(contestxuser);
////        contestxusersforuserid.add(contestxuser);
//        
//        em.getTransaction().begin();
//        em.merge(contestid);
//        em.merge(userid);
//        
//        em.persist(contestxuser);
//        em.getTransaction().commit();
    }

//    ---------------------------------------ImageOfWeek :--------------------------------------------
    
    @Override
    public Collection<Imageofweek> showImageOfWeek() 
    {
        return em.createNamedQuery("Imageofweek.findAll").getResultList();
    }
    
//    ---------------------------------------TipsType :--------------------------------------------
    
    @Override
    public Collection<Tipstype> showAllTipsType() 
    {
        return em.createNamedQuery("Tipstype.findAll").getResultList();
    }
    
    
    //SEARCH QUERY
    
   @Override
   public List<Object[]> getTipsTypeName(String TipsTypeName)
   {
       String sql = "SELECT t.TipsTypeName,pt.PhotographyTipsPhoto,pt.PhotographyTipsDescription FROM photograohytips pt,tipstype t WHERE t.TipsTypeName LIKE '"+TipsTypeName+"'";
       return em.createNativeQuery(sql).getResultList();
   }
    
//    ---------------------------------------PhotographyTips :--------------------------------------------
    
    @Override
    public Collection<Photographytips> ShowAllPhotographyTipsById(int tipsTypeId) 
    {
       Collection<Photographytips> temp = em.createQuery("select phototips from Photographytips phototips where phototips.tipsTypeId.tipsTypeId = :tipsTypeId").setParameter("tipsTypeId",tipsTypeId).getResultList();
        for (Photographytips photographytips : temp) {
            System.out.println(photographytips.getPhotographyTipsDescription());
        }
       return em.createQuery("select phototips from Photographytips phototips where phototips.tipsTypeId.tipsTypeId = :tipsTypeId").setParameter("tipsTypeId",tipsTypeId).getResultList();
    }

}
