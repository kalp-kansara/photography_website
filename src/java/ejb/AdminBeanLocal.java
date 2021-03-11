/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.*;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author KALP
 */
@Local
public interface AdminBeanLocal {
    
//    ---------------------------------------User :--------------------------------------------
    
    Collection getAllUserInformation();
//    void DisableUser(int UserId ,Boolean IsDisable);
    
//    ---------------------------------------Roles :--------------------------------------------
    
        Collection getAllRoles();
        void addRoles(String RoleName , String RolePermission);
        void updateRoles(int RoleId , String RoleName , String RolePermission);
        void deleteRoles(int RoleId);
    
//    ---------------------------------------Permission :--------------------------------------------
//    
//    Collection getAllPermission();
//    void addPermission(String PermissionGroup,String PermissionGroup2,String PermissionName,String Description);
//    void updatePermission(int PermissionId,String PermissionGroup,String PermissionGroup2,String PermissionName,String Description);
//    void DeletePermission(int PermissionId);
//    
//    ---------------------------------------RolePermission :--------------------------------------------
//    
//    Collection getAllRolePermission();
//    void addRolePermission(int PermissionId);
//    void updateRolePermission(int RolePermissionId,int RoleId);
//    void deleteRolePermission(int RolePermissionId);
//    
//    ---------------------------------------UserRole :--------------------------------------------
//    
//    Collection getAllUserRole();
    
//    ---------------------------------------PhotoCategory :--------------------------------------------
    
    Collection<Photocategory> getAllPhotoCategory();
    void addPhotoCategory(String PhotoCategoryName , String Description, String PhotoCategoryPath);
    void updatePhotoCategory(int CategoryId , String PhotoCategoryName , String Description, String PhtoCategoryPath);
    void deletePhotoCategory(int CategoryId);
    Photocategory getPhotoCategoryById(int categoryId);

    
////    ---------------------------------------UserPhotoUpload :--------------------------------------------
//    
//    void ApprovePhotoByAdmin(int UserUploadId,int UserId,int CategoryId,String PhotoDescription,String PhotoUrl,Boolean IsApprove);
//    Collection showAllUploadedPhotoByUserId(int UserId , int CategoryId);
//    
//    ---------------------------------------Plans :--------------------------------------------
    
    Collection<Plans> showAllPlans();
    Plans showplansById(int PlansId);
    void addPlans(String PlansName , String PlansPrice , String PlansDescription);
    void updatePlans(int PlansId , String PlansName , String PlansPrice , String PlansDescription);
    void removePlans(int PlansId);
    
//    ---------------------------------------PlansXUser :--------------------------------------------
    
    Collection showAllPlansXUser();
//    showAllPlansXUserByUserId
    
//    ---------------------------------------Payment :--------------------------------------------
    
    Collection showAllPaymentType();
    void addPaymentType(String PaymentTypeName , String Description);
    void updatePaymentType(int PaymentId ,String PaymentTypeName , String Description);
    void removePaymentType(int PaymentId);
    
//    ---------------------------------------Contest :--------------------------------------------
    
    Collection<Contest> showAllContest();
    Contest getContestById(int ContestId);
    void addContest(String ContestName,String StartDate,String EndDate,String Status,String ContestType,String ContestDescription,String ContestPhotoPath); //IsActive bydefault true,IsCancle bydefault false
    void updateContest(int ContestId,String ContestName,String StartDate,String EndDate,String Status,String ContestType,String ContestDescription, String ContestPhotoPath);
    void deleteContest(int ContestId);

//    ---------------------------------------ContestXUser :--------------------------------------------
    
    Collection getAllContestXUser();
//    getAllContestXUserByContestId();
//    getAllContestXUserByUserId();
    
//    ---------------------------------------VottingXContest :--------------------------------------------
    
//     Collection showVottingXContest();
//     Collection showVotting(int Votting , int ContestXUserId , int ContestId);
    
//    ---------------------------------------ContestUserPayment :--------------------------------------------
    
//    Collection showPaymentDetailsofContest();
    
//    ---------------------------------------ImageOfWeek :--------------------------------------------
    
    Collection showImageOfWeek();
    Imageofweek getImageOfWeekById(int ImageOfWeekId);
    void addImageOfWeek(String ImageUrl , String SocialsitePhotoUrl , String SocialsiteProfileUrl,String ImageDescription , String DateOfDeclaration); //insert dateofdeclaration is bydefault when admin upload it
    void updateImageOfWeek(int ImageOfWeekId , String ImageUrl , String ImageDescription , String SocialsitePhotoUrl , String SocialsiteProfileUrl , String DateOfDeclaration);
    void removeImageOfWeek(int ImageOfWeekId);
    
//    ---------------------------------------TipsType :--------------------------------------------
    
    Collection showAllTipsType();
    Tipstype getTipsTypeById(int TipsTypeId);
    void addTipsType(String TipsTypeName , String TipsTypeDescription, String TipsTypePhotoPath);
    void updateTipsType(int TipsTypeId , String TipsTypeName , String TipsTypeDescription , String TipsTypePhotoPath);
    void removeTipsType(int TipsTypeId);
    
//    ---------------------------------------PhotographyTips :--------------------------------------------
    
    Collection<Photographytips> ShowAllPhotographyTips();
    Photographytips getPhotographyTipsById(int PhotographyTipsId);
    void addPhotoGraphyTips(int TipsId , String PhotographyTipsPhoto , String PhotographyTipsDescription);
    void updatePhotoGraphyTips(int PhotographyTipsId , int TipsId , String PhotographyTipsPhoto , String PhotographyTipsDescription);
    void deletePhotoGraphyTips(int PhotographyTipsId);

//    ---------------------------------------Reviews :--------------------------------------------
//    Collection ShowAllReviews();
    
}
