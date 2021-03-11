/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Plans;
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
@Path("plansREST")
@RequestScoped
public class PlansREST {

    @EJB UserBeanLocal ubl;
    @EJB AdminBeanLocal abl;
    
    @Context
    private UriInfo context;

    public PlansREST() {
    }
    
    @GET
    @Path("getALlPlans")
    public Collection<Plans> getAllPlans()
    {
        return abl.showAllPlans();
    }
    
    @GET
    @Path("getPlansById/{PlansId}")
    public Plans getPlansById(int PlansId)
    {
        return abl.showplansById(PlansId);
    }
    
    @POST
    @Path("AddPlans/{PlansName}/{PlansPrice}/{Description}")
    public void AddPlans(@PathParam("PlansName") String PlansName,@PathParam("PlansPrice")String PlansPrice,@PathParam("Description") String Description)
    {
        abl.addPlans(PlansName, PlansPrice, Description);
    }
    
    @POST
    @Path("UpdatePlans/{PlansId}/{PlansName}/{PlansPrice}/{Description}")
    public void UpdatePlans(@PathParam("PlansId")int PlansId, @PathParam("PlansName") String PlansName,@PathParam("PlansPrice")String PlansPrice,@PathParam("Description") String Description)
    {
        abl.updatePlans(PlansId, PlansName, PlansPrice, Description);
    }
    
    @GET
    @Path("DeletePlans/{PlansId}")
    public void DeletePlans(int PlansId)
    {
        abl.removePlans(PlansId);
    }
//    .request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    
}
