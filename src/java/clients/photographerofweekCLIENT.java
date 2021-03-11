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
 * Jersey REST client generated for REST resource:photographerofweekREST
 * [photographerofweekREST]<br>
 * USAGE:
 * <pre>
 *        photographerofweekCLIENT client = new photographerofweekCLIENT();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author KALP
 */
public class photographerofweekCLIENT {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/photographyProject/webresources";

    public photographerofweekCLIENT() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("photographerofweekREST");
    }

    public <T> T getAllImageOfWeekData(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllImageOfWeekData");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T DeleteImageOfWeekDataById(Class<T> responseType, int ImageOfWeekId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("DeleteImageOfWeekDataById/{0}", new Object[]{ImageOfWeekId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllImageOfWeekDataById(Class<T> responseType, int ImageOfWeekId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllImageOfWeekDataById/{0}", new Object[]{ImageOfWeekId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void AddImageOfTheWeek(String ImageOfWeekPhotoPath, String SocialProfileUrl, String SocialPhotoUrl,  String DeclarationDate,String ImageDescription) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddImageOfTheWeek/{0}/{1}/{2}/{3}/{4}", new Object[]{ImageOfWeekPhotoPath, SocialProfileUrl, SocialPhotoUrl, ImageDescription, DeclarationDate})).request().post(null);
    }

    public void UpdateImageOfTheWeek(int ImageOfTheWeekId, String ImageOfWeekPhotoPath, String SocialProfileUrl, String SocialPhotoUrl, String DeclarationDate, String ImageDescription) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateImageOfTheWeek/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{ImageOfTheWeekId, ImageOfWeekPhotoPath, SocialProfileUrl, SocialPhotoUrl, ImageDescription, DeclarationDate})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
