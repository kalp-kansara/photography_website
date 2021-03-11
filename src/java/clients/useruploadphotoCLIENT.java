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
 * Jersey REST client generated for REST resource:useruplodphotoREST
 * [useruplodphotoREST]<br>
 * USAGE:
 * <pre>
 *        useruploadphotoCLIENT client = new useruploadphotoCLIENT();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author KALP
 */
public class useruploadphotoCLIENT {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Project-war/webresources";

    public useruploadphotoCLIENT() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("useruplodphotoREST");
    }

    public <T> T getAllImageByphotoCategoryName(Class<T> responseType, int CategoryId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllImageByphotoCategoryId/{0}", new Object[]{CategoryId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
