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
 * Jersey REST client generated for REST resource:photographyTipsREST
 * [photographyTipsREST]<br>
 * USAGE:
 * <pre>
 *        photographyTipsCLIENT client = new photographyTipsCLIENT();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author KALP
 */
public class photographyTipsCLIENT {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/photographyProject/webresources";

    public photographyTipsCLIENT() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("photographyTipsREST");
    }

    public void updatePhotographyTips(int PhotographyTipsId, int TipsTypeId, String PhotographyTipsPhotoPath, String PhotographyTipsDescription) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePhotographyTips/{0}/{1}/{2}/{3}", new Object[]{PhotographyTipsId, TipsTypeId, PhotographyTipsPhotoPath, PhotographyTipsDescription})).request().post(null);
    }

    public <T> T deletePhotographyTips(Class<T> responseType, int PhotographyTipsId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("deletePhotographyTips/{0}", new Object[]{PhotographyTipsId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPhotographyTipsById(Class<T> responseType, int PhotographyTipsId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPhotographyTipsById/{0}", new Object[]{PhotographyTipsId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllPhotographyTips(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPhotographyTips");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addPhotographyTips(int TipsTypeId, String PhotographyTipsPhotoPath, String PhotographyTipsDescription) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPhotographyTips/{0}/{1}/{2}", new Object[]{TipsTypeId, PhotographyTipsPhotoPath, PhotographyTipsDescription})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
