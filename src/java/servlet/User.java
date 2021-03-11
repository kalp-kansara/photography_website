/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import clients.useruploadphotoCLIENT;
import ejb.AdminBeanLocal;

import ejb.UserBeanLocal;
import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.*;

/**
 *
 * @author KALP
 */
public class User extends HttpServlet {

    @EJB
    UserBeanLocal ubl;
    @EJB
    AdminBeanLocal abl;

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
            out.println("<title>Servlet User</title>");
            out.println("</head>");
            out.println("<body>");

//======================================User Registration=============================================             
//            ubl.Registration("j@gmail.com", "123", "je", "mi", "nee", "j", "j.com", Boolean.FALSE);
//            System.out.println("Success..!");
//=====================================Registration User Over================================================  
//======================================Update Profile============================================= 
//            ubl.UpdateProfile(15, "abc@gmail.com", "abc", "abc", "abc", "abc", "9874563210", "abc", "abc.com", Boolean.FALSE);
//======================================Update Profile over========================================= 
//======================================Display Photocategory=============================================
//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY PHOTO CATEGORY |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//            Collection<Photocategory> photocategorys = acl.getAllPhotoCategory();
//            for (Photocategory photocategory : photocategorys) {
//               
//                out.println("Category Id : " + photocategory.getCategoryId()+ "<br />"
//                        + "Category Name : " + photocategory.getCategoryName() + "<br />"
//                                + "Category Description : " + photocategory.getDescription());
//                
//                out.println("<hr />");
//                
//            }
//======================================Display Photocategory over=============================================
//======================================Add UserUploadPhoto=============================================
//                ubl.addUserUploadPhoto(1, 1, "abc", "abc", Boolean.TRUE);
//======================================Add UserUploadPhoto over=============================================
//======================================Update UserUploadPhoto=============================================
//                  ubl.updateUserUploadPhoto(4, 1, 1, "xyz", "xyz", Boolean.TRUE);
//======================================Update UserUploadPhoto over=============================================
//======================================Delete UserUploadPhoto=============================================
//                ubl.deleteUserUploadPhoto(4);
//======================================Delete UserUploadPhoto over=============================================
//======================================Display User Upload Photo=============================================
//            out.println("=============================="+ "<br/>");
//            out.println("| DISPLAY ALL UPLOADED PHOTOS |" + "<br/>");
//            out.println("==============================" + "<br/>");
//            
//            Collection<Useruploadphoto> useruploadphotos = ubl.showAllUploadedPhoto();
//            
//            for (Useruploadphoto useruploadphoto : useruploadphotos) {
//               
//                out.println("User Upload Photo Id : " + useruploadphoto.getUserUploadPhotoId() + "<br />"
//                        + "User Id : " + useruploadphoto.getUserId().getFirstName()+ "<br />"
//                                + "Category Id : " + useruploadphoto.getCategoryId().getCategoryName() + "<br />"
//                                        + "Photo Description : " + useruploadphoto.getPhotoDescription() + "<br />"
//                                                + "Photo Url : " + useruploadphoto.getPhotoPathOriginal()+ "<br />"
//                                                        + "Aproove :" + useruploadphoto.getIsApprove());
//                
//                out.println("<hr />");
//
//            }
//======================================Display User Upload Photo over=============================================
//======================================Display Plans=============================================
//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY PLANS |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//            Collection<Plans> planses = ubl.showAllPlans();
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
//======================================Add PlanXUser=============================================
//              ubl.choosePlans(15, 2);
//======================================Add PlanXUser over=============================================
//======================================Display Payment Type=============================================
//
//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY PAYMENT TYPE |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//            Collection<Payment> payments = ubl.showAllPaymentType();
//            
//            for (Payment payment : payments) {
//                out.println("Payment Type Id : " + payment.getPaymentId()+ "<br />"
//                        + "Payment Type Name : " + payment.getPaymentType()+ "<br />"
//                                + "Payment Type Description : " + payment.getDescription() );
//                                        
//                
//                out.println("<hr />");
//
//            }
//======================================Display Payment Type over=============================================
//======================================Display Contest=============================================
//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY CONTEST LIST |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//            Collection<Contest> contests = ubl.showAllContest();
//            
//            for (Contest contest1 : contests) {
//                out.println("Contest Id : " + contest1.getContestId()+ "<br />"
//                        + "Contest Name : " + contest1.getContestName()+ "<br />"
//                                + "Contest Start Date : " + contest1.getStartDate()+"<br />"
//                                        + "Contest End Date : " + contest1.getEndDate() +"<br />"
////                                                + "Active Contest : " +contest1.getIsActive() + "<br />"
//                                                        + "Contest Photo Path : " + contest1.getContestPhotoPath()+ "<br />"
//                                                                
//                                                                + "Status : " + contest1.getStatus() + "<br />"
//                                                                        + "Contest Type : " + contest1.getContestType() + "<br />"
//                                                                                + "Contest Description : " + contest1.getContestDescription() );
//                                
//                out.println("<hr />");
//
//            }
//======================================Display Contest over=============================================
//search
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
//======================================Display TipsType by Name=============================================
//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY TIPS TYPE BY NAME |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//             List<Object[]>  l= ubl.getTipsTypeName("Mobile Phototgraphy tips");
//             
//             for (Object[] objects : l) 
//            {
//                out.println("Tips Name : " + objects[0] + "<br /> Photo : " +objects[1] + "<br /> Description : " +objects[2] + "<br />");
//                out.println("<hr />");
//            }
//======================================Display TipsType by Name over=============================================
//======================================search  getContestByContestType=============================================
//            out.println("=========================="+ "<br/>");
//            out.println("| SEARCH BY CONTEST TYPE |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//             List<Object[]>  l1= ubl.getContestByStatus("over");
//             
//             for (Object[] objects : l1) 
//            {
//                out.println("ContestName : " + objects[0] + "<br /> Status : " +objects[1] + "<br /> ContestType : " +objects[2] + "<br /> ContestDescription"  + objects[3] + "<br />");
//                out.println("<hr/>");
//            }
//======================================search  getContestByActive=============================================             
//             out.println("=========================="+ "<br/>");
//            out.println("| SEARCH BY CONTEST ACTIVE OR NOT |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//             List<Object[]>  l2= ubl.getContestByActive(Boolean.FALSE);
//             
//             for (Object[] objects : l2) 
//            {
//                out.println("ContestName : " + objects[0] + "<br /> Status : " +objects[1] + "<br /> ContestType : " +objects[2] + "<br />ContestDescription"  + objects[3] + "<br />");
//                out.println("<hr />");
//            }
//======================================search  getContestByStatus=============================================             
//            out.println("=========================="+ "<br/>");
//            out.println("| SEARCH BY CONTEST STATUS |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//             List<Object[]>  l3= ubl.getContestByStatus("over");
//             
//             for (Object[] objects : l3) 
//            {
//                out.println("ContestName : " + objects[0] + "<br /> Status : " +objects[1] + "<br /> ContestType : " +objects[2] + "<br /> ContestDescription"  + objects[3] + "<br />");
//                out.println("<hr />");
//            }
//======================================search  on photocategory name=============================================                          
//            out.println("=========================="+ "<br/>");
//            out.println("| SEARCH BY CATEGORY |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//             List<Object[]>  l4= ubl.ShowPhotoCategorVise("Nature");
//             
//             for (Object[] objects : l4) 
//            {
//                out.println("PhotoUrl : " + objects[0] + "<br /> PhotoDescription : " +objects[1] + "<br /> FirstName : " +objects[2] + "<br /> CategoryName : " + objects[3] + "<br />");
//                out.println("<hr />");
//            }
//
//             
//             
//======================================Add ContestXUser=============================================
//            Contestxuser contestxuser = new Contestxuser();
//            contestxuser.setContestId(new Contest(1));
//            contestxuser.setUserId(new Users(1));
//            contestxuser.setContestImage(0);
//            contestxuser.setUploadDateTime(new Date());
//            contestxuser.setSocialsiteProfileUrl("abc.com/kalpkansara");
//           ubl.RegistrationInContest(contestxuser);
//======================================Add ContestXUser over=============================================
//======================================Display Photography Tips=============================================
//            out.println("=========================="+ "<br/>");
//            out.println("| DISPLAY ALL PHOTOGRAPHY TIPS |" + "<br/>");
//            out.println("==========================" + "<br/>");
//            
//            Collection<Photograohytips> photograohytipses = acl.showPhotographyTips();
//            
//            for (Photograohytips photograohytipse : photograohytipses) {
//                
//                out.println("Photography Tips Id : " +photograohytipse.getPhotographyTipsId() + "<br />"
//                        + "Tips Type Name : " + photograohytipse.getTipsId().getTipsTypeName()+ "<br />"
//                                + "Photography Tips Photo : " + photograohytipse.getPhotographyTipsPhoto() + "<br />"
//                                        + "Photography Tips Description : " + photograohytipse.getPhotographyTipsDescription());
//                
//                out.println("<hr />");
//
//            }
//======================================Display Photography Tips over============================================= 
//============================================================================================================
            Response res;
            useruploadphotoCLIENT client;
            Collection<Useruploadphoto> collection;
            GenericType<Collection<Useruploadphoto>> genericType = null;
            
            client = new useruploadphotoCLIENT();
            collection = new ArrayList<Useruploadphoto>();
            genericType = new GenericType<Collection<Useruploadphoto>>(){};
            res = client.getAllImageByphotoCategoryName(Response.class, 1);
            collection = res.readEntity(genericType);
            
            for (Useruploadphoto useruploadphoto : collection) {
                out.println(useruploadphoto.getPhotoPathOriginal() + " and " + useruploadphoto.getUserUploadPhotoId());
            }
            
            


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
