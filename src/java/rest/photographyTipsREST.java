/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Photographytips;
import java.util.Collection;
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
@Path("photographyTipsREST")
@RequestScoped
public class photographyTipsREST {

    @Context
    private UriInfo context;

    @EJB UserBeanLocal ubl;
    @EJB AdminBeanLocal abl;
    
    public photographyTipsREST() {
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllPhotographyTips")
    public Collection<Photographytips> getAllPhotographyTips() {
        return abl.ShowAllPhotographyTips();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getPhotographyTipsById/{PhotographyTipsId}")
    public Photographytips getPhotographyTipsById(int PhotographyTipsId)
    {
        return abl.getPhotographyTipsById(PhotographyTipsId);
    }
    
    @POST
    @Path("addPhotographyTips/{TipsTypeId}/{PhotographyTipsPhotoPath}/{PhotographyTipsDescription}")
    public void addPhotographyTips(@PathParam("TipsTypeId")int TipsTypeId,
            @PathParam("PhotographyTipsPhotoPath")String PhotographyTipsPhotoPath,
            @PathParam("PhotographyTipsDescription")String PhotographyTipsDescription)
    {
        abl.addPhotoGraphyTips(TipsTypeId, PhotographyTipsPhotoPath, PhotographyTipsDescription);
    }
    
    @POST
    @Path("updatePhotographyTips/{PhotographyTipsId}/{TipsTypeId}/{PhotographyTipsPhotoPath}/{PhotographyTipsDescription}")
    public void updatePhotographyTips(@PathParam("PhotographyTipsId")int PhotographyTipsId,
            @PathParam("TipsTypeId")int TipsTypeId,
            @PathParam("PhotographyTipsPhotoPath")String PhotographyTipsPhotoPath,
            @PathParam("PhotographyTipsDescription")String PhotographyTipsDescription)
    {
        abl.updatePhotoGraphyTips(PhotographyTipsId, TipsTypeId, PhotographyTipsPhotoPath, PhotographyTipsDescription);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deletePhotographyTips/{PhotographyTipsId}")
    public void deletePhotographyTips(@PathParam("PhotographyTipsId")int PhotographyTipsId)
    {
        abl.deletePhotoGraphyTips(PhotographyTipsId);
    }
}
