/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clients.plansCLIENT;
import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Plans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author KALP
 */
@Named(value = "plansBean")
@ViewScoped
public class plansBean implements Serializable{

    public plansBean() {
    }
    
    @Inject
    ServletContext context;
    @EJB
    UserBeanLocal ubl;
    @EJB
    AdminBeanLocal abl;
    plansCLIENT pClient = new plansCLIENT();
    
    int PlansId;
    String PlansName,PlansPrice,Description;
    private Collection<Plans> plansList;

    public int getPlansId() {
        return PlansId;
    }

    public void setPlansId(int PlansId) {
        this.PlansId = PlansId;
    }

    public String getPlansName() {
        return PlansName;
    }

    public void setPlansName(String PlansName) {
        this.PlansName = PlansName;
    }

    public String getPlansPrice() {
        return PlansPrice;
    }

    public void setPlansPrice(String PlansPrice) {
        this.PlansPrice = PlansPrice;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Collection<Plans> getPlansList() {
        return plansList;
    }

    public void setPlansList(Collection<Plans> plansList) {
        this.plansList = plansList;
    }
    
    public Collection<Plans> getAllPlans()
    {
        Response response = pClient.getAllPlans(Response.class);
        ArrayList<Plans> arrayList = new ArrayList<Plans>();
        GenericType<Collection<Plans>> genericType = new GenericType<Collection<Plans>>(){
        };
        arrayList = (ArrayList<Plans>) response.readEntity(genericType);
        return arrayList;
    }
    
    public String AddPlans()
    {
//        pClient.AddPlans(PlansName, PlansPrice, Description);
        abl.addPlans(PlansName, PlansPrice, Description);
        return "plans.xhtml?faces-redirect=true";
    }
    
    public void getPlansById(int plansId)
    {
//        Response response = pClient.getPlansById(Response.class, plansId);
//        GenericType<Plans> genericType = new GenericType<Plans>(){
//        };
//        Plans plans = response.readEntity(genericType);
//        this.PlansId = plans.getPlansId();
//        PlansName = plans.getPlansName();
//        PlansPrice = plans.getPlansPrice();
//        Description = plans.getDescription();
        Plans plans = abl.showplansById(plansId);
        System.out.println(plans.getPlansName());
        this.PlansId = plans.getPlansId();
        PlansName = plans.getPlansName();
        PlansPrice = plans.getPlansPrice();
        Description = plans.getDescription();
    }
    
    public void UpdatePlans()
    {
//        pClient.UpdatePlans(PlansId, PlansName, PlansPrice, Description);
        abl.updatePlans(PlansId, PlansName, PlansPrice, Description);
        getAllPlans();
    }
    
    public void DeletePlans(int PlansId)
    {
//        pClient.DeletePlans(Response.class, PlansId);
        abl.removePlans(PlansId);
        getAllPlans();
    }
    
    public void reset()
    {
        setPlansId(0);
        setPlansName("");
        setPlansPrice("");
        setDescription("");
    }
    
}
