/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.UserBeanLocal;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("test")
@RequestScoped
public class Test {

    @Context
    private UriInfo context;
    @EJB
    UserBeanLocal ubl;
    
    public Test() {
    }

//    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void display()
    {
        
    }
    
    @POST
    @Path("adduseruploadphoto/{UserId}/{CategoryId}/{PhotoDescription}/{IsApprove}/{PhotopathOriginal}/{PhotopathWithWM}")
    public void adduseruploadphoto(@PathParam("UserId")int UserId,@PathParam("CategoryId")int CategoryId,@PathParam("PhotoDescription")String PhotoDescription,@PathParam("IsApprove")Boolean IsApprove,@PathParam("PhotopathOriginal")String PhotopathOriginal,@PathParam("PhotopathWithWM")String PhotopathWithWM)
    {
        ubl.addUserUploadPhoto(UserId, CategoryId, PhotoDescription, PhotopathOriginal, PhotopathWithWM, IsApprove);
    }
    
}
