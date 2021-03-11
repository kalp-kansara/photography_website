/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author KALP
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(rest.PlansREST.class);
        resources.add(rest.PortfolioRESTResource.class);
        resources.add(rest.Test.class);
        resources.add(rest.contestREST.class);
        resources.add(rest.photographerofweekREST.class);
        resources.add(rest.photographyTipsREST.class);
        resources.add(rest.registrationREST.class);
        resources.add(rest.tipsREST.class);
        resources.add(rest.useruplodphotoREST.class);
    }
    
}
