/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Imageofweek;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author KALP
 */
@Path("photographerofweekREST")
@RequestScoped
public class photographerofweekREST {

    @EJB UserBeanLocal ubl;
    @EJB AdminBeanLocal abl;
    @Context
    private UriInfo context;
    
    public photographerofweekREST() {
    }

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllImageOfWeekData")
    public Collection<Imageofweek> getAllImageOfWeekData() {
       return abl.showImageOfWeek();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllImageOfWeekDataById/{ImageOfWeekId}")
    public Imageofweek getAllImageOfWeekDataById(@PathParam("ImageOfWeekId")int ImageOfWeekId) {
       return abl.getImageOfWeekById(ImageOfWeekId);
    }
    
    @POST
    @Path("AddImageOfTheWeek/{ImageOfWeekPhotoPath}/{SocialProfileUrl}/{SocialPhotoUrl}/{DeclarationDate}/{ImageDescription}")
    public void AddImageOfTheWeek(@PathParam("ImageOfWeekPhotoPath") String ImageOfWeekPhotoPath,
            @PathParam("SocialProfileUrl") String SocialProfileUrl,
            @PathParam("SocialPhotoUrl") String SocialPhotoUrl,
            @PathParam("ImageDescription") String ImageDescription,
            @PathParam("DeclarationDate") String DeclarationDate)
    {
        abl.addImageOfWeek(ImageOfWeekPhotoPath, SocialProfileUrl, SocialPhotoUrl, ImageDescription, DeclarationDate);
    }
    
    @POST
    @Path("UpdateImageOfTheWeek/{ImageOfTheWeekId}/{ImageOfWeekPhotoPath}/{SocialProfileUrl}/{SocialPhotoUrl}/{DeclarationDate}/{ImageDescription}")
    public void UpdateImageOfTheWeek(@PathParam("ImageOfTheWeekId")int ImageOfTheWeekId,
            @PathParam("ImageOfWeekPhotoPath") String ImageOfWeekPhotoPath,
           
            @PathParam("SocialProfileUrl") String SocialProfileUrl,
            @PathParam("SocialPhotoUrl") String SocialPhotoUrl,
            @PathParam("ImageDescription") String ImageDescription,
            @PathParam("DeclarationDate") String DeclarationDate)
    {
        abl.updateImageOfWeek(ImageOfTheWeekId, ImageOfWeekPhotoPath, SocialProfileUrl, SocialPhotoUrl, ImageDescription, DeclarationDate);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("DeleteImageOfWeekDataById/{ImageOfWeekId}")
    public void DeleteImageOfWeekDataById(@PathParam("ImageOfWeekId")int ImageOfWeekId)
    {
        abl.removeImageOfWeek(ImageOfWeekId);
    }
}
