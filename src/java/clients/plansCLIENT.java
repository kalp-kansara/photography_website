/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:PlansREST [plansREST]<br>
 * USAGE:
 * <pre>
 *        plansCLIENT client = new plansCLIENT();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author KALP
 */
public class plansCLIENT {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/photographyProject/webresources";

    public plansCLIENT() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("plansREST");
    }

    public void AddPlans(String PlansName, String PlansPrice, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddPlans/{0}/{1}/{2}", new Object[]{PlansName, PlansPrice, Description})).request().post(null);
    }

    public <T> T getPlansById(Class<T> responseType, int PlansId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPlansById/{0}", new Object[]{PlansId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdatePlans(int PlansId, String PlansName, String PlansPrice, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdatePlans/{0}/{1}/{2}/{3}", new Object[]{PlansId, PlansName, PlansPrice, Description})).request().post(null);
    }

    public <T> T DeletePlans(Class<T> responseType, int PlansId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("DeletePlans/{0}", new Object[]{PlansId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllPlans(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getALlPlans");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
