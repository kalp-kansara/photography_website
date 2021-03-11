/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;


import entity.*;

import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author KALP
 */
@Stateless
public class AdminBean implements AdminBeanLocal {

   @PersistenceContext(unitName = "ProjectPU")
    EntityManager em;
   
//    @PostConstruct
//    public void init()
//    {
//        em = Persistence.createEntityManagerFactory("ProjectPU").createEntityManager();
//    }
   
//    ---------------------------------------User :-------------------------------------------- 
    @Override
    public Collection getAllUserInformation() 
    {
        return em.createNamedQuery("Users.findAll").getResultList();
    }

//    ---------------------------------------Roles :--------------------------------------------    
    @Override
    public Collection getAllRoles() 
    {
        return em.createNamedQuery("Roles.findAll").getResultList();
    }
    
    @Override
    public void addRoles(String RoleName , String RolePermission) 
    {
        Roles roles = new Roles();
        roles.setRoleName(RoleName);
        roles.setDescription(RolePermission);
//        
        em.persist(roles);
//        
    }
 
    @Override
    public void updateRoles(int RoleId , String RoleName , String RolePermission) 
    {
        Roles roles = em.find(Roles.class,RoleId);
        
        roles.setRoleName(RoleName);
        roles.setDescription(RolePermission);
//        
        em.merge(roles);
//        
    }

    @Override
    public void deleteRoles(int RoleId) 
    {
        Roles roles = em.find(Roles.class, RoleId);
        
        em.remove(roles);
        
    }

    
//    ---------------------------------------PhotoCategory :--------------------------------------------    
   
    @Override
    public Collection<Photocategory> getAllPhotoCategory() 
    {
        System.out.println("Hello in ejvb");
//      EntityManager em1 = Persistence.createEntityManagerFactory("ProjectPU").createEntityManager();
//        return em.createNamedQuery("Photocategory.findAll").getResultList();
        Collection<Photocategory> temp=em.createNamedQuery("Photocategory.findAll").getResultList();
        for(Photocategory pc:temp){
            System.out.println("get all category Name :"+pc.getCategoryName());
        }
        return temp;
    }
    
    @Override
    public void addPhotoCategory(String PhotoCategoryName , String Description, String PhotoCategoryPath) 
    {
        Photocategory photocategory = new Photocategory();
//        photocategory.setCategoryId(photoCategoryId);
        photocategory.setCategoryName(PhotoCategoryName);
        photocategory.setDescription(Description);
        photocategory.setCategoryPhotoPath(PhotoCategoryPath);
        
        System.out.println("in bean add method");
        em.persist(photocategory);
        
    }

    @Override
    public void updatePhotoCategory(int CategoryId , String PhotoCategoryName , String Description , String PhtoCategoryPath) 
    {
        Photocategory photocategory = (Photocategory) em.find(Photocategory.class, CategoryId);
        
        photocategory.setCategoryName(PhotoCategoryName);
        photocategory.setDescription(Description);
        photocategory.setCategoryPhotoPath(PhtoCategoryPath);
//        
        em.merge(photocategory);
        Collection<Photocategory> temp=em.createNamedQuery("Photocategory.findAll").getResultList();
        for(Photocategory pc:temp){
            System.out.println("category"+pc.getCategoryName());
        }
        Photocategory photocategory1 = (Photocategory) em.find(Photocategory.class, CategoryId);
        System.err.println("updated name : " + photocategory1.getCategoryName());
        
//        
    }
    
//     public void updateCompany(int CompanyId, String CompanyName, String ContactNo1, String ContactNo2, String EmailId,String AgencyName,String AgencyNumber) {
//        CompanyTB objCompany=(CompanyTB) em.find(CompanyTB.class, CompanyId);
//        objCompany.setCompanyName(CompanyName);
//        objCompany.setContactNo1(ContactNo1);
//        objCompany.setContactNo2(ContactNo2);
//        objCompany.setEmailId(EmailId);
//        objCompany.setAgencyName(AgencyName);
//        objCompany.setAgencyNumber(AgencyNumber);
//        objCompany.setIsActive(true);
//        objCompany.setModifiedOn(new Date());
//        em.merge(objCompany);
//    }
    
    @Override
    public void deletePhotoCategory(int CategoryId) 
    {
        Photocategory photocategory = em.find(Photocategory.class, CategoryId);
        
        em.remove(photocategory);
        
    }
    
    @Override
    public Photocategory getPhotoCategoryById(int categoryId)
    {
        return (Photocategory) em.find(Photocategory.class, categoryId);
    }

    
//    ---------------------------------------Plans :--------------------------------------------    
    
     @Override
    public Collection<Plans> showAllPlans() 
    {
        return em.createNamedQuery("Plans.findAll").getResultList();
    }
    
    @Override
    public Plans showplansById(int PlansId)
    {
        Plans p=em.find(Plans.class,PlansId);
        System.out.println(p);
        return  p;
    }
    
    @Override
    public void addPlans(String PlansName , String PlansPrice , String PlansDescription) 
    {
        Plans plans = new Plans();
        plans.setPlansName(PlansName);
        plans.setPlansPrice(PlansPrice);
        plans.setDescription(PlansDescription);
        
        em.persist(plans);   
        
    }

    @Override
    public void updatePlans(int PlansId , String PlansName , String PlansPrice , String PlansDescription) 
    {
        Plans plans = em.find(Plans.class, PlansId);
        plans.setPlansName(PlansName);
        plans.setPlansPrice(PlansPrice);
        plans.setDescription(PlansDescription);
        
        
        em.merge(plans);
        
    }

    @Override
    public void removePlans(int PlansId) 
    {
        Plans plans = em.find(Plans.class,PlansId);
        
        em.remove(plans);
        
    }

    

 //    ---------------------------------------PlansXUser :--------------------------------------------   
    
    @Override
    public Collection showAllPlansXUser() 
    {
        return em.createNamedQuery("Plansxuser.findAll").getResultList();
    }

    
//    ---------------------------------------Payment :--------------------------------------------
    
    @Override
    public Collection showAllPaymentType() 
    {
        return em.createNamedQuery("Payment.findAll").getResultList();
    }
    
    @Override
    public void addPaymentType(String PaymentTypeName , String Description) 
    {
        Payment payment = new Payment();
        payment.setPaymentTypeName(PaymentTypeName);
        payment.setPaymentTypeDescrption(Description);
        
        em.persist(payment);
        
    }

    @Override
    public void updatePaymentType(int PaymentId ,String PaymentTypeName , String Description) 
    {
        Payment payment = em.find(Payment.class, PaymentId);
        payment.setPaymentTypeName(PaymentTypeName);
        payment.setPaymentTypeDescrption(Description);
        
        em.merge(payment);
        
    }

    @Override
    public void removePaymentType(int PaymentId) 
    {
        Payment payment = em.find(Payment.class, PaymentId);
        
        em.remove(payment);
        
    }
 
//    ---------------------------------------Contest :--------------------------------------------
    
    @Override
    public Collection<Contest> showAllContest() 
    {
        return em.createNamedQuery("Contest.findAll").getResultList();
    }
    
    @Override
    public Contest getContestById(int ContestId)
    {
        return (Contest) em.find(Contest.class, ContestId);
    }
    
    @Override
    public void addContest(String ContestName, String StartDate, String EndDate, String Status, String ContestType, String ContestDescription, String ContestPhotoPath) {
        System.out.println("in admin bean");
        Contest contest = new Contest();
        contest.setContestName(ContestName);
        contest.setStartDate(StartDate);
        contest.setEndDate(EndDate);
        contest.setContestStatus(Status);
        contest.setContestType(ContestType);
        contest.setContestDescription(ContestDescription);
        contest.setContestPhotoPath(ContestPhotoPath);
        
        em.persist(contest);
        
    }

    @Override
    public void updateContest(int ContestId,String ContestName,String StartDate,String EndDate,String Status,String ContestType,String ContestDescription,String ContestPhotoPath) 
    {
        Contest contest = em.find(Contest.class, ContestId);
        contest.setContestName(ContestName);
        contest.setStartDate(StartDate);
        contest.setEndDate(EndDate);
        contest.setContestStatus(Status);
        contest.setContestType(ContestType);
        contest.setContestDescription(ContestDescription);
        contest.setContestPhotoPath(ContestPhotoPath);
        em.merge(contest);
        
    }

    @Override
    public void deleteContest(int ContestId) 
    {
        Contest contest = em.find(Contest.class, ContestId);
        
        em.remove(contest);
        
    }

    
    
//    ---------------------------------------ContestXUser :--------------------------------------------    
    
    @Override
    public Collection getAllContestXUser() 
    {
        return em.createNamedQuery("Contestxuser.findAll").getResultList();
    }

    
    
//    ---------------------------------------ImageOfWeek :--------------------------------------------
    
    @Override
    public Collection showImageOfWeek() 
    {
        return em.createNamedQuery("Imageofweek.findAll").getResultList();
    }
    
    @Override
    public Imageofweek getImageOfWeekById(int ImageOfWeekId)
    {
        return (Imageofweek)em.find(Imageofweek.class, ImageOfWeekId);
    }
    
    @Override
    public void addImageOfWeek(String ImageUrl , String SocialsiteProfileUrl , String SocialsitePhotoUrl , String ImageDescription , String DateOfDeclaration) 
    {
        Imageofweek imageofweek = new Imageofweek();
        imageofweek.setImageOfWeekPhotoPath(ImageUrl);
        imageofweek.setSocialProfileUrl(SocialsiteProfileUrl);
        imageofweek.setSocialPhotoUrl(SocialsitePhotoUrl);
        imageofweek.setImageDescription(ImageDescription);
        imageofweek.setDeclarationDate(DateOfDeclaration);
        
        em.persist(imageofweek);
        
    }

    @Override
    public void updateImageOfWeek(int ImageOfWeekId , String ImageUrl , String ImageDescription , String SocialsitePhotoUrl , String SocialsiteProfileUrl , String DateOfDeclaration) 
    {
        Imageofweek imageofweek = em.find(Imageofweek.class, ImageOfWeekId);
        imageofweek.setImageOfWeekPhotoPath(ImageUrl);
        imageofweek.setImageDescription(ImageDescription);
        imageofweek.setSocialPhotoUrl(SocialsitePhotoUrl);
        imageofweek.setSocialProfileUrl(SocialsiteProfileUrl);
        imageofweek.setDeclarationDate(DateOfDeclaration);
        
        em.merge(imageofweek);
        
    }

    @Override
    public void removeImageOfWeek(int ImageOfWeekId) 
    {
        Imageofweek imageofweek = em.find(Imageofweek.class, ImageOfWeekId);
        
        em.remove(imageofweek);
        
    }

    
//    ---------------------------------------TipsType :--------------------------------------------
    
    @Override
    public Collection showAllTipsType() 
    {
        return em.createNamedQuery("Tipstype.findAll").getResultList();
    }
    
    @Override
    public Tipstype getTipsTypeById(int TipsTypeId)
    {
        return (Tipstype)em.find(Tipstype.class, TipsTypeId);
    }
    
    @Override
    public void addTipsType(String TipsTypeName , String TipsTypeDescription , String TipsTypePhotoPath) 
    {
        Tipstype tipstype = new Tipstype();
        tipstype.setTipsTypeName(TipsTypeName);
        tipstype.setTipsTypeDescription(TipsTypeDescription);
        tipstype.setTipsTypePhotoPath(TipsTypePhotoPath);
        
        em.persist(tipstype);
        
    }

    @Override
    public void updateTipsType(int TipsTypeId , String TipsTypeName , String TipsTypeDescription,String TipsTypePhotoPath) 
    {
        Tipstype tipstype = em.find(Tipstype.class, TipsTypeId);
        tipstype.setTipsTypeName(TipsTypeName);
        tipstype.setTipsTypeDescription(TipsTypeDescription);
        tipstype.setTipsTypePhotoPath(TipsTypePhotoPath);
        
        em.merge(tipstype);
        
    }

    @Override
    public void removeTipsType(int TipsTypeId) 
    {
        Tipstype tipstype = em.find(Tipstype.class, TipsTypeId);
        
        em.remove(tipstype);
        
    }


//    ---------------------------------------PhotographyTips :--------------------------------------------
    
    @Override
    public Collection<Photographytips> ShowAllPhotographyTips() 
    {
       return em.createNamedQuery("Photograohytips.findAll").getResultList();
    }
    
    @Override
    public Photographytips getPhotographyTipsById(int PhotographyTipsId)
    {
        return em.find(Photographytips.class, PhotographyTipsId);
    }
    
    @Override
    public void addPhotoGraphyTips(int TipsId , String PhotographyTipsPhoto , String PhotographyTipsDescription) 
    {
        Photographytips photographytips = new Photographytips();
        
        Tipstype tipstypeid = em.find(Tipstype.class, TipsId);
        
        Collection<Photographytips> photographytipsfortipsid = tipstypeid.getPhotographytipsCollection();
        
        photographytips.setTipsTypeId(tipstypeid);
        photographytips.setPhtographyTipsPhotoPath(PhotographyTipsPhoto);
        photographytips.setPhotographyTipsDescription(PhotographyTipsDescription);
        photographytipsfortipsid.add(photographytips);
        
        
        em.merge(tipstypeid);
        em.persist(photographytips);
        
    }

    @Override
    public void updatePhotoGraphyTips(int PhotographyTipsId , int TipsId , String PhotographyTipsPhoto , String PhotographyTipsDescription) 
    {
        Photographytips photograohytips = new Photographytips();
        Tipstype tipstypeid = em.find(Tipstype.class, TipsId);
        
        Collection<Photographytips> photograohytipsfortipsid = tipstypeid.getPhotographytipsCollection();
        
        photograohytips.setTipsTypeId(tipstypeid);
        photograohytips.setPhtographyTipsPhotoPath(PhotographyTipsPhoto);
        photograohytips.setPhotographyTipsDescription(PhotographyTipsDescription);
        photograohytipsfortipsid.add(photograohytips);
        
        
        em.merge(tipstypeid);
        em.merge(photograohytips);
        
    }

    @Override
    public void deletePhotoGraphyTips(int PhotographyTipsId) 
    {
        Photographytips photograohytips1 = em.find(Photographytips.class, PhotographyTipsId);
        
        em.remove(photograohytips1);
        
    }

}
