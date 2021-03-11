/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.AdminBeanLocal;
import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KALP
 */
public class Admin extends HttpServlet {

    @EJB AdminBeanLocal abl;
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Admin</title>");            
            out.println("</head>");
            out.println("<body>");
            
//======================================Display all Profile=============================================
            
            out.println("==================="+ "<br/>");
            out.println("| DISPLAY PROFILES |" + "<br/>");
            out.println("===================" + "<br/>");
//            Collection<Users> userses = abl.getAllUserInformation();
//            
//            for (Users userse : userses) {
//                out.println("UserId : " + userse.getUserId() + "<br />"
//                        + "UserName : " + userse.getFirstName() + " " + userse.getMiddleName() + " " + userse.getLastName() + "<br /> "
//                        + "Email-Id : " + userse.getEmailId() + "<br />"
//                                
//                                        + "Profile Photo : " + userse.getProfilePhoto() + "<br />"
//                                                + "SocialSite URL" + userse.getUserProfileURL() + "<br />"
//                                                        + "Disable : " + userse.getIsDisable());
//                out.println("<hr />");
//            }
//======================================Display all Profile over=============================================     





//======================================Add Role=============================================
//            Roles roles = new Roles();
//            roles.setName("a");
//            roles.setDescription("n!!");
//            abl.addRoles(roles);
//======================================Add Role over=============================================
//======================================Display Role=============================================
//            out.println("==================="+ "<br/>");
//            out.println("| DISPLAY ROLES |" + "<br/>");
//            out.println("===================" + "<br/>");
//            
//            Collection<Roles> roleses = abl.getAllRoles();
//            for (Roles rolese : roleses) {
//                out.println("Role Id : " + rolese.getRoleId() + "<br />"
//                        + "Role Name : " + rolese.getName() + "<br />"
//                                + "Role Description : " + rolese.getDescription());
//                
//                out.println("<hr />");
//            }
//======================================Display Role over=============================================
//======================================Update Role=============================================
//            Roles roles = new Roles(4);
//            roles.setName("Judge");
//            roles.setDescription("Judge give Decision of contest!!");
//           abl.updateRoles(roles);
//======================================Update Role over=============================================
//======================================Delete Role=============================================
//            Roles roles = new Roles(5);
//            abl.deleteRoles(roles);
//======================================Delete Role Over=============================================


//======================================Add PhotoCategory=============================================
//               Photocategory photocategory = new Photocategory();
//               photocategory.setCategoryName("gvhbj");
//               photocategory.setDescription("vbncgfvhb");
               abl.addPhotoCategory("cal", "cal", "cal.jpg");
//======================================Add PhotoCategory over=============================================
//======================================Display Photocategory from allCommon bean=============================================
            out.println("=========================="+ "<br/>");
            out.println("| DISPLAY PHOTO CATEGORY |" + "<br/>");
            out.println("==========================" + "<br/>");
            
            Collection<Photocategory> photocategorys = abl.getAllPhotoCategory();
            for (Photocategory photocategory1 : photocategorys) {
                out.println("Category Id : " + photocategory1.getCategoryId()+ "<br />"
                        + "Category Name : " + photocategory1.getCategoryName() + "<br />"
                                + "Category Description : " + photocategory1.getDescription());
                
                out.println("<hr />");
                
            }
//======================================Display Photocategory over from allCommon bean=============================================
//======================================Update Photocategory=============================================
//            Photocategory photocategory = new Photocategory(8);
//            photocategory.setCategoryName("abc");
//            photocategory.setDescription("abc");
//            abl.updatePhotoCategory(photocategory);
//======================================update Photocategory over=============================================
//======================================Delete Photocategory=============================================
//            Photocategory photocategory = new Photocategory(8);
//            abl.deletePhotoCategory(photocategory);
//======================================Delete Photocategory over=============================================



//======================================Add Plans=============================================
//            Plans plans = new Plans();
//            plans.setPlansName("Bronz");
//            plans.setDescription("Bronz Plans in Download 6 Photos in 20% off and get more benifits");
//            plans.setPlansPrice("600 INR");
//            abl.addPlans(plans);
//======================================Add Plans over=============================================
//======================================Edit Plans=============================================
//            Plans plans = new Plans(4);
//            plans.setPlansName("abc");
//            plans.setDescription("abc");
//            plans.setPlansPrice("4560 INR");
//            abl.updatePlans(plans);
//======================================Edit Plans over=============================================
//======================================Remove Plans=============================================

//            Plans plans = new Plans(4);
//            abl.removePlans(plans);
            
//======================================Remove Plans over=============================================
//======================================Display Plans=============================================

//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY PLANS |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//            Collection<Plans> planses = acl.showAllPlans();
//            
//            for (Plans planse : planses) {
//                out.println("Plans Id : " + planse.getPlansId()+ "<br />"
//                        + "Plans Name : " + planse.getPlansName()+ "<br />"
//                                + "Plans Description : " + planse.getDescription() + "<br />"
//                                        + "Plans Price : " + planse.getPlansPrice());
//                
//                out.println("<hr />");
//
//            }
//======================================Display Plans over=============================================



//======================================Add Payment=============================================
//            Payment payment = new Payment();
//            payment.setPaymentType("Paytm");
//            payment.setDescription("Payment via Paytm");
//            abl.addPaymentType(payment);
//======================================Add Payment over=============================================
//======================================Update Payment over=============================================
//            Payment payment = new Payment(2);
//            payment.setPaymentType("GooglePay");
//            payment.setDescription("Payment via GooglePay");
//            abl.updatePaymentType(payment);
//======================================Update Paymentover=============================================
//======================================Delete Payment over=============================================
//               Payment payment = new Payment(3);
//               abl.removePaymentType(payment);
//======================================DeletePayment over=============================================
//======================================Display Payment Type=============================================

//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY PAYMENT TYPE |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//            Collection<Payment> payments = abl.showAllPaymentType();
//            
//            for (Payment payment1 : payments) {
//                out.println("Payment Type Id : " + payment1.getPaymentId()+ "<br />"
//                        + "Payment Type Name : " + payment1.getPaymentType()+ "<br />"
//                                + "Payment Type Description : " + payment1.getDescription() );
//                                        
//                
//                out.println("<hr />");
//
//            }
//======================================Display Payment Type over=============================================



//======================================Add Contest=============================================

//            Contest contest = new Contest();
//            contest.setContestName("Contest3");
//            contest.setStartDate(new Date(07/11/2019));
//            contest.setEndDate(new Date(27/11/2019));
//            contest.setIsActive(true);
//            contest.setIsCancle(false);
//            contest.setStatus("over");
//            contest.setContestType("unpaid");
//            contest.setContestDescription("Successfully Over and Declare winer of contest 1!!!");
//            abl.addContest(contest);

//======================================Add Contest over=============================================
//======================================Update Contest=============================================

//            Contest contest = new Contest(1);
//            contest.setContestName("Contest3");
//            contest.setStartDate(new Date(07/11/2019));
//            contest.setEndDate(new Date(27/11/2019));
//            contest.setIsActive(true);
//            contest.setIsCancle(false);
//            contest.setStatus("over");
//            contest.setContestType("unpaid");
//            contest.setContestDescription("Successfully Over and Declare winer of contest 3!!!");
//            abl.updateContest(contest);
            
//======================================Update Contest over=============================================
//======================================Delete Contest=============================================
//            Contest contest = new Contest(3);
//            abl.deleteContest(contest);
//======================================Delete Contest over=============================================
//======================================Display Contest=============================================

//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY CONTEST LIST |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//            Collection<Contest> contests = acl.showAllContest();
//            
//            for (Contest contest1 : contests) {
//                out.println("Contest Id : " + contest1.getContestId()+ "<br />"
//                        + "Contest Name : " + contest1.getContestName()+ "<br />"
//                                + "Contest Start Date : " + contest1.getStartDate()+"<br />"
//                                        + "Contest End Date : " + contest1.getEndDate() +"<br />"
//                                                + "Active Contest : " +contest1.getIsActive() + "<br />"
//                                                        + "Cancle Contest : " + contest1.getIsCancle() + "<br />"
//                                                                + "Status : " + contest1.getStatus() + "<br />"
//                                                                        + "Contest Type : " + contest1.getContestType() + "<br />"
//                                                                                + "Contest Description : " + contest1.getContestDescription() );
//                                
//                out.println("<hr />");
//
//            }

//======================================Display Contest over=============================================



//======================================Add Image Of Week=============================================

//    Imageofweek imageofweek1 = new Imageofweek();
//    imageofweek1.setImageUrl("week1.jpeg");
//    imageofweek1.setImageDescription("PHOTOT GRAPHER OF THIS WEEK IS kaps kansara");
//    imageofweek1.setSocialSitePhotoUrl("www.instagram.com/aw541dfv");
//    imageofweek1.setSocialSiteProfileUrl("www.instagram.com/kalp_kansara");
//    imageofweek1.setDateOfDeclaration(null);
//    abl.addImageOfWeek(imageofweek1);

//======================================Add Image Of Week Ovwe=============================================
//======================================Update Image Of Week=============================================
//    Imageofweek imageofweek1 = new Imageofweek(1);
//    imageofweek1.setImageUrl("week2.jpeg");
//    imageofweek1.setImageDescription("PHOTOT GRAPHER OF THIS WEEK IS SOME ONE");
//    imageofweek1.setSocialSitePhotoUrl("www.instagram.com/fgh85hbgv");
//    imageofweek1.setSocialSiteProfileUrl("www.instagram.com/someone");
//    imageofweek1.setDateOfDeclaration(new Date(10/2/2020));
//    abl.updateImageOfWeek(imageofweek1);
//======================================Update Image Of Week Over=============================================
//======================================Delete Image Of Week=============================================
//      Imageofweek imageofweek1 = new Imageofweek(2);
//      abl.removeImageOfWeek(imageofweek1);
//======================================Delete Image Of Week Over=============================================
//======================================Display Image Of Week=============================================

//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY Image Of Week LIST |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//            Collection<Imageofweek> imageofweeks = acl.showImageOfWeek();
//          
//            for (Imageofweek imageofweek : imageofweeks) {
//         
//                out.println("Image Of Week Id : " + imageofweek.getImageOfWeekId()+ "<br />"
//                        + "Image URL : " + imageofweek.getImageUrl()+ "<br />"
//                                + "Image Description : " +imageofweek.getImageDescription()+"<br />"
//                                        + "Scialsite Photo URL : " + imageofweek.getSocialSitePhotoUrl() +"<br />"
//                                                + "Socialsite Profile URL : " +imageofweek.getSocialSiteProfileUrl() + "<br />"
//                                                        + "Date Of Declaration : " + imageofweek.getDateOfDeclaration() + "<br />" );
//                                
//                out.println("<hr />");
//
//            }

//======================================Display Image Of Week over=============================================



//======================================Add TipsType=============================================
//              Tipstype tipstype = new Tipstype();
//              tipstype.setTipsTypeName("Mobile Phototgraphy tips");
//              tipstype.setTipsTypeDescription("Mobile Phototgraphy tips");
//              abl.addTipsType(tipstype);
              
//======================================Add TipsType over=============================================
//======================================Update TipsType=============================================
//              Tipstype tipstype = new Tipstype(2);
//              tipstype.setTipsTypeName("DSLR Phototgraphy tips");
//              tipstype.setTipsTypeDescription("DSLR Phototgraphy tips");
//              abl.updateTipsType(tipstype);
//======================================Update TipsType over=============================================
//======================================Delete TipsType=============================================
//                Tipstype tipstype = new Tipstype(3);
//                abl.removeTipsType(tipstype);
//======================================Delete TipsType over=============================================

//======================================Display TipsType =============================================
//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY TIPS TYPE |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//             Collection<Tipstype> tipstypes = abl.getAllTipsType();
//             
//            for (Tipstype tipstype1 : tipstypes) {
//         
//                out.println("Tips Type Id : " + tipstype1.getTipsTypeId() + "<br />"
//                        + "Tips Type Name : " + tipstype1.getTipsTypeDescription()+ "<br />"
//                                + "Tips Type Description : " +tipstype1.getTipsTypeDescription()+"<br />");
//                out.println("<hr />");
//
//            }
//======================================Display TipsType over=============================================

//======================================Display User Upload Photo=============================================
//
//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY ALL UPLOADED PHOTOS |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//            Collection<Useruploadphoto> useruploadphotos = acl.showAllUploadedPhoto();
//            
//            for (Useruploadphoto useruploadphoto : useruploadphotos) {
//               
//                out.println("User Upload Photo Id : " + useruploadphoto.getUserUploadPhotoId() + "<br />"
//                        + "User Id : " + useruploadphoto.getUserId().getFirstName()+ "<br />"
//                                + "Category Id : " + useruploadphoto.getCategoryId().getCategoryName() + "<br />"
//                                        + "Photo Description : " + useruploadphoto.getPhotoDescription() + "<br />"
//                                                + "Photo Url : " + useruploadphoto.getPhotoUrl() + "<br />"
//                                                        + "Aproove :" + useruploadphoto.getIsApprove());
//                
//                out.println("<hr />");
//
//            }
//======================================Display User Upload Photo over=============================================



//======================================Display PlanXUser=============================================
//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY PLANxUSER |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//            Collection<Plansxuser> plansxusers = abl.showAllPlansXUser();
//            
//            for (Plansxuser plansxuser : plansxusers) {
//                
//                out.println("PlaneXUser Id : " + plansxuser.getPlansXUserId() + "<br />"
//                        + "User Name : " + plansxuser.getUserId().getFirstName()+ "<br />"
//                                + "Plans Name : " + plansxuser.getPlansId().getPlansName());
//                
//                out.println("<hr />");
//
//            }
//======================================Display PlanXUser over=============================================


//======================================Display ContestXUser=============================================

//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY CONTESTxUSER |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//            Collection<Contestxuser> contestxusers = abl.getAllContestXUser();
//          
//            for (Contestxuser contestxuser : contestxusers) {
//                
//                out.println("ContestXUser Id : " + contestxuser.getContestXUserId() + "<br />"
//                        + "User Name : " + contestxuser.getUserId().getFirstName()+ "<br />"
//                                + "Contest Name : " + contestxuser.getContestId().getContestName() + "<br />"
//                                        + "Contest Image : " + contestxuser.getContestImage() + "<br />"
//                                                + "Registration Time : " + contestxuser.getUploadDateTime() + "<br />"
//                                                        + "Socialsite Profile URL : " + contestxuser.getSocialsiteProfileUrl());
//                
//                out.println("<hr />");
//
//            }
//======================================Display ContestXUser over=============================================


//======================================Add Photography Tips=============================================
//              Photograohytips photograohytips = new Photograohytips();
//              photograohytips.setTipsId(new Tipstype(1));
//              photograohytips.setPhotographyTipsPhoto("abc.jpeg");
//              photograohytips.setPhotographyTipsDescription("tips 1 inserted");
//              abl.addPhotoGraphyTips(photograohytips);
//======================================Add Photography Tips over=============================================
//======================================Update Photography Tips=============================================
//              Photograohytips photograohytips = new Photograohytips(2);
//              photograohytips.setTipsId(new Tipstype(1));
//              photograohytips.setPhotographyTipsPhoto("xyz.jpeg");
//              photograohytips.setPhotographyTipsDescription("tips 2 inserted");
//              abl.updatePhotoGraphyTips(photograohytips);
//======================================Update Photography Tips over=============================================
//======================================Delete Photography Tips=============================================
//               Photograohytips photograohytips = new Photograohytips(3);
//               abl.deletePhotoGraphyTips(photograohytips);
//======================================Delete Photography Tips over=============================================

//======================================Display Photography Tips=============================================
            out.println("=========================="+ "<br/>");
            out.println("| DISPLAY ALL PHOTOGRAPHY TIPS |" + "<br/>");
            out.println("==========================" + "<br/>");
            
            Collection<Photographytips> photograohytipses = abl.ShowAllPhotographyTips();
            
            for (Photographytips photograohytipse : photograohytipses) {
                
                out.println("Photography Tips Id : " +photograohytipse.getPhotographyTipsId() + "<br />"
                        + "Tips Type Name : " + photograohytipse.getTipsTypeId().getTipsTypeName()+ "<br />"
                                + "Photography Tips Photo : " + photograohytipse.getPhtographyTipsPhotoPath()+ "<br />"
                                        + "Photography Tips Description : " + photograohytipse.getPhotographyTipsDescription());
                
                out.println("<hr />");

            }
//======================================Display Photography Tips over============================================= 


            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
