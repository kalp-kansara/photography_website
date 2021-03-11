/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Tipstype;
import java.util.Collection;
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
@Path("tipsREST")
@RequestScoped
public class tipsREST {

    @EJB UserBeanLocal ubl;
    @EJB AdminBeanLocal abl;
    
    @Context
    private UriInfo context;

    public tipsREST() {
    }

    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getTipsById/{tipstypeId}")
    public Tipstype getTipsTypeById(int tipstypeId)
    {
        return abl.getTipsTypeById(tipstypeId);
    }
    
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllTips")
    public Collection<Tipstype> getAllTips() {
        return abl.showAllTipsType();
    }

    @POST
    @Path("AddTipsType/{tipstypeName}/{tipstypeDescription}/{tipstypePhotoPath}")
    public void AddTipsType(@PathParam("tipstypeName")String tipstypeName,@PathParam("tipstypeDescription")String tipstypeDescription,@PathParam("tipstypePhotoPath")String tipstypePhotoPath)
    {
        abl.addTipsType(tipstypeName, tipstypeDescription, tipstypePhotoPath);
    }
    
    @POST
    @Path("UpdateTipsType/{tipstypeId}/{tipstypeName}/{tipstypeDescription}/{tipstypePhotoPath}")
     public void UpdateTipsType(@PathParam("tipstypeId")int tipstypeId,@PathParam("tipstypeName")String tipstypeName,@PathParam("tipstypeDescription")String tipstypeDescription,@PathParam("tipstypePhotoPath")String tipstypePhotoPath)
    {
        abl.updateTipsType(tipstypeId, tipstypeName, tipstypeDescription, tipstypePhotoPath);
    }
     
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     @Path("deleteTipsType/{tipstypeId}")
     public void deleteTipsType(@PathParam("tipstypeId")int tipstypeId)
     {
         abl.removeTipsType(tipstypeId);
     }
}
