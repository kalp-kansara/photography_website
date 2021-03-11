/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Contest;
import java.util.Collection;
import java.util.Date;
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
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author KALP
 */
@Path("contestREST")
@RequestScoped
public class contestREST {

    @EJB UserBeanLocal ubl;
    @EJB AdminBeanLocal abl;
   
    @Context
    private UriInfo context;

    public contestREST() {
    }
    
    @GET
    @Path("upcomingContest/{Status}")
    public Collection<Contest> getContestbyStatus(String Status)
    {
        return ubl.getContestbyStatus(Status);
    }
    
    @GET
    @Path("getContestById/{ContestId}")
    public Contest getContestById(@PathParam("ContestId")int ContestId)
    {
        return abl.getContestById(ContestId);
    }
    
    @GET
    @Path("getallcontestdata")
    public Collection<Contest> getallContestData()
    {
        return ubl.showAllContest();
    }
    
    @POST
    @Path("AddContest/{ContestName}/{ContestType}/{StartDate}/{EndDate}/{ContestDescription}/{ContestStatus}/{ContestPhotoPath}")
    public void addContest(@PathParam("ContestName") String ContestName,@PathParam("ContestType")String ContestType,@PathParam("StartDate") String StartDate,@PathParam("EndDate")String EndDate,@PathParam("ContestDescription")String ContestDescription,@PathParam("ContestStatus")String ContestStatus,@PathParam("ContestPhotoPath")String ContestPhotoPath)
    {
        System.out.println("in rest");
        abl.addContest(ContestName, StartDate, EndDate, ContestStatus, ContestType, ContestDescription, ContestPhotoPath);
    }
    
    @POST
    @Path("UpdateContest/{ContestId}/{ContestName}/{ContestType}/{StartDate}/{EndDate}/{ContestDescription}/{ContestStatus}/{ContestPhotoPath}")
    public void UpdateContest(@PathParam("ContestId") int ContestId, @PathParam("ContestName") String ContestName,@PathParam("ContestType")String ContestType,@PathParam("StartDate") String StartDate,@PathParam("EndDate")String EndDate,@PathParam("ContestDescription")String ContestDescription,@PathParam("ContestStatus")String ContestStatus,@PathParam("ContestPhotoPath")String ContestPhotoPath)
    {
        abl.updateContest(ContestId, ContestName, StartDate, EndDate, ContestStatus, ContestType, ContestDescription, ContestPhotoPath);
    }
    
    @GET
    @Path("DeleteContest/{ContestId}")
    public void DeleteContest(@PathParam("ContestId") int ContestId)
    {
        abl.deleteContest(ContestId);
    }
    
    @GET
    @Path("getcontestdatafromtype/{ContestType}")
    public Collection<Contest> getContestByContestType(String ContestType)
    {
        return ubl.getContestbyContestType(ContestType);
    }
    
    
    @GET
    @Path("getContestbyStatusAndContestType/{Status}/{ContestType}")
    public Collection<Contest> getContestbyStatusAndContestType(@PathParam("status") String Status,@PathParam("ContestType")String ContestType)
    {
        return ubl.getContestbyStatusAndContestType(Status, ContestType);
    }
    
    
//    .request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
}
