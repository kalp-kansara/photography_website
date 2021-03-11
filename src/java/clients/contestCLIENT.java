/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients;

import java.util.Date;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:contestREST [contestREST]<br>
 * USAGE:
 * <pre>
 *        contestCLIENT client = new contestCLIENT();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author KALP
 */
public class contestCLIENT {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/photographyProject/webresources";

    public contestCLIENT() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("contestREST");
    }

    public void UpdateContest(int ContestId, String ContestName, String ContestType, String StartDate, String EndDate, String ContestDescription, String ContestStatus, String ContestPhotoPath) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateContest/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{ContestId, ContestName, ContestType, StartDate, EndDate, ContestDescription, ContestStatus, ContestPhotoPath})).request().post(null);
    }

    public <T> T getContestbyStatus(Class<T> responseType, String Status) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("upcomingContest/{0}", new Object[]{Status}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getContestById(Class<T> responseType, int ContestId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getContestById/{0}", new Object[]{ContestId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addContest(String ContestName, String ContestType, String StartDate, String EndDate, String ContestDescription, String ContestStatus, String ContestPhotoPath) throws ClientErrorException {
        System.out.println("in client");
        webTarget.path(java.text.MessageFormat.format("AddContest/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{ContestName, ContestType, StartDate, EndDate, ContestDescription, ContestStatus, ContestPhotoPath})).request().post(null);
    }

    public <T> T getContestbyStatusAndContestType(Class<T> responseType, String Status, String ContestType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getContestbyStatusAndContestType/{0}/{1}", new Object[]{Status, ContestType}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getallContestData(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getallcontestdata");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T DeleteContest(Class<T> responseType, int ContestId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("DeleteContest/{0}", new Object[]{ContestId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getContestByContestType(Class<T> responseType, String ContestType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getcontestdatafromtype/{0}", new Object[]{ContestType}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }

    
}
