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
 * Jersey REST client generated for REST resource:Test [test]<br>
 * USAGE:
 * <pre>
 *        testCLIENT client = new testCLIENT();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author KALP
 */
public class testCLIENT {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/photographyProject/webresources";

    public testCLIENT() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("test");
    }

    public void adduseruploadphoto(int UserId, int CategoryId, String PhotoDescription, Boolean IsApprove, String PhotopathOriginal, String PhotopathWithWM) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("adduseruploadphoto/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{UserId, CategoryId, PhotoDescription, IsApprove, PhotopathOriginal, PhotopathWithWM})).request().post(null);
    }

    public <T> T display(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
