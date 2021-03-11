/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Photocategory;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
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
@Path("portfolioREST")
//@DeclareRoles({"Admin","User"})
@RequestScoped
public class PortfolioRESTResource {

    
    @EJB UserBeanLocal ubl;
    @EJB AdminBeanLocal abl;
    
    @Context
    private UriInfo context;

    public PortfolioRESTResource() {
    }
    
//    @RolesAllowed("Admin")
    @GET
    @Path("getPhotoCategoryById/{categoryId}")
    public Photocategory getPhotoCategoryById(@PathParam("categoryId")int categoryId)
    {
        return abl.getPhotoCategoryById(categoryId);
    }
    
//    @RolesAllowed("Admin")
    @GET
    @Path("getAllCategory")
    public Collection<Photocategory> getAllPhotoCategory()
    {
        return abl.getAllPhotoCategory();
    }
    
//    @RolesAllowed("Admin")
    @POST
    @Path("addPhotoCategory/{PhotoCategoryName}/{Description}/{CategoryPath}")
    public void addPhotoCategory(@PathParam("PhotoCategoryName")String PhotoCategoryName,@PathParam("Description") String Description,@PathParam("CategoryPath") String CategoryPaths)
    {
        abl.addPhotoCategory(PhotoCategoryName, Description,CategoryPaths);
    }
    
    @POST
    @Path("updatePhotoCategory/{categoryId}/{categoryName}/{description}/{PhotoCategoryPath}")
    public void updatePhotoCategory(@PathParam("categoryId")int categoryId,@PathParam("categoryName")String categoryName,@PathParam("description")String Description,@PathParam("PhotoCategoryPath")String PhotoCategoryPath)
    {
        abl.updatePhotoCategory(categoryId, categoryName, Description, PhotoCategoryPath);
    }
    
//    @RolesAllowed("Admin")
    @GET
    @Path("deletePhotoCategory/{categoryId}")
    public void deletePhotoCategory(@PathParam("categoryId")int categoryId)
    {
        abl.deletePhotoCategory(categoryId);
    }
    
    @GET
    @Path("allPhotoCategory")
    public Collection<Photocategory> allPhotoCategory()
    {
        return ubl.getAllPhotoCategoryName();
    }
//    .request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
//    https://localhost:8181/photographyProject/webresources
    
}
