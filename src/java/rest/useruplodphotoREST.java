/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.UserBeanLocal;
import entity.Useruploadphoto;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author KALP
 */
@Path("useruplodphotoREST")
@RequestScoped
public class useruplodphotoREST {

    @EJB UserBeanLocal ubl; 
    @Context
    private UriInfo context;

    public useruplodphotoREST() {
    }
    
    @GET
    @Path("getAllImageByphotoCategoryId/{CategoryId}")
    public List<Object[]> getAllImageByphotoCategoryName(@PathParam("PhotoCategoryId") int PhotoCategoryId)
    {
       return  ubl.ShowPhotoCategorVise(PhotoCategoryId);
    }
    
//    @GET
//    public void getallImages()
//    {
////        System.out.println(ubl.showAllUploadedPhoto());
//        ubl.showAllUploadedPhoto();
//    }
    
//    .request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
}
