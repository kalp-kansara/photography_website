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
 * Jersey REST client generated for REST resource:tipsREST [tipsREST]<br>
 * USAGE:
 * <pre>
 *        TipsCLIENT client = new TipsCLIENT();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author KALP
 */
public class TipsCLIENT {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/photographyProject/webresources";

    public TipsCLIENT() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("tipsREST");
    }

    public <T> T deleteTipsType(Class<T> responseType, int tipstypeId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("deleteTipsType/{0}", new Object[]{tipstypeId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getTipsTypeById(Class<T> responseType, int tipstypeId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getTipsById/{0}", new Object[]{tipstypeId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void AddTipsType(String tipstypeName, String tipstypeDescription, String tipstypePhotoPath) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddTipsType/{0}/{1}/{2}", new Object[]{tipstypeName, tipstypeDescription, tipstypePhotoPath})).request().post(null);
    }

    public <T> T getAllTips(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllTips");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateTipsType(int tipstypeId, String tipstypeName, String tipstypeDescription, String tipstypePhotoPath) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateTipsType/{0}/{1}/{2}/{3}", new Object[]{tipstypeId, tipstypeName, tipstypeDescription, tipstypePhotoPath})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
