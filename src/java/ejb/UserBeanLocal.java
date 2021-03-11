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
import javax.ejb.Local;

/**
 *
 * @author KALP
 */
@Local
public interface UserBeanLocal 
{
//    ---------------------------------------Users :--------------------------------------------
    
    void Registration(String EmailId , String Password , String FirstName , String MiddleName , String LastName , String Profilephoto , String UserProfileUrl , Boolean IsDisable);
    void UpdateProfile(int UserId ,String EmailId , String Password , String FirstName , String MiddleName , String LastName , String MobileNumber , String Profilephoto , String UserProfileUrl , Boolean IsDisable);
//    void ForgotPassword();
    
//    ---------------------------------------PhotoCategory :--------------------------------------------    

    Collection<Photocategory> getAllPhotoCategory();
    Collection<Photocategory> getAllPhotoCategoryName();
    
    
//    ---------------------------------------UserUploadPhoto :--------------------------------------------
    
//    Collection getAllPhotosOfEachUsers(int UserId);
    void addUserUploadPhoto(int UserId , int CategoryId , String PhotoDescription , String PhotoPathOriginal, String PhotoPathWM , Boolean IsApprove);  //bydefault IsApprove is false
    void updateUserUploadPhoto(int UserUploadPhotoId , int UserId , int CategoryId , String PhotoDescription , String PhotoPathOriginal, String PhotoPathWM ,Boolean IsApprove);
    void deleteUserUploadPhoto(int UserUploadPhotoId);
    Collection<Useruploadphoto> showAllUploadedPhoto();
    Collection<Useruploadphoto> showAllUploadedPhototCatId(int CategoryId);
//    Collection<Useruploadphoto> getAllPhotoCategoryName();
    
//    
//    //SEARCH QUERY 
    List<Object[]>  ShowPhotoCategorVise(int CategoryId);

//    ---------------------------------------Plans :--------------------------------------------
    
    Collection showAllPlans();
    
//    ---------------------------------------PlansXUser :--------------------------------------------
    
    void choosePlans(int PlansId , int UserId);

//    ---------------------------------------Payment :--------------------------------------------
    
    Collection<Payment> showAllPaymentType();
    
//    ---------------------------------------Contest :--------------------------------------------
    
    Collection showAllContest();
    Collection<Contest> getContestbyStatus(String Status);
    Collection<Contest> getContestbyContestType(String ContestType);
    Collection<Contest> getContestbyStatusAndContestType(String Status,String ContestType);
    //SEARCH QUERY 
//    Collection searchOnContestStartDateEndDate(Date StartDate , Date EndDate);
    List<Object[]> getContestByStatus(String Status);
    List<Object[]> getContestByActive(Boolean IsActive);
    List<Object[]> getContestByContestType(String ContestType);

//    ---------------------------------------ContestXUser :--------------------------------------------
    
//    void showPerticipateInContest(int ContestXUserId , int ContestId , int UserId , String ContestImage , Date UploadDateTime , String SocialSitePhotoUrl);
    void RegistrationInContest(int ContestId , int UserId , String ContestImage , Date UploadDateTime , String SocialSitePhotoUrl); //enter upload datetime in bydefault
    
//    ---------------------------------------VottingXUser :--------------------------------------------
    
//    Collection showVottingXContest();
//    void doVotting(int ContestXUserId,int UserId,int ContestId,int Votting);
//    //SEARCH QUERY
//    Collection showVotting(int Votting , int ContestXUserId , int ContestId);

//    ---------------------------------------ImageOfWeek :--------------------------------------------
    
    Collection<Imageofweek> showImageOfWeek();
    
//    ---------------------------------------TipsType :--------------------------------------------

      Collection<Tipstype> showAllTipsType();
    //SEARCH QUERY
    List<Object[]> getTipsTypeName(String TipsTypeName);

//    ---------------------------------------PhotographyTips :--------------------------------------------
    
    Collection<Photographytips> ShowAllPhotographyTipsById(int TipstypeId);
    
//    ---------------------------------------Review :--------------------------------------------
    
//    Collection showAllReview();
//    void AddReview(int UserId,String ReviewDescription);

}
