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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author KALP
 */
@Path("registrationREST")
public class registrationREST {

    @EJB
    UserBeanLocal ubl;
    @Context
    private UriInfo context;

    
    public registrationREST() {
    }

    @POST
    @Path("registration/{Email}/{Password}/{FirstName}/{MiddleName}/{LastName}/{ProfilePhoto}/{IsDisable}")
    public void RegistrationUser(@PathParam("Email")String Email,@PathParam("Password")String Password,@PathParam("FirstName")String FirstName,@PathParam("MiddleName")String MiddleName,@PathParam("LastName")String LastName,@PathParam("ProfilePhoto")String ProfilePhoto,@PathParam("IsDisable")String IsDisable)
    {
        ubl.Registration(Email, Password, FirstName, MiddleName, LastName, ProfilePhoto, ProfilePhoto, Boolean.FALSE);
    }
}
