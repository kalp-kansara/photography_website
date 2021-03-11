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
 * Jersey REST client generated for REST resource:PortfolioRESTResource
 * [portfolioREST]<br>
 * USAGE:
 * <pre>
 *        portfolioCLIENT client = new portfolioCLIENT();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author KALP
 */
public class portfolioCLIENT {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/photographyProject/webresources";

    public portfolioCLIENT() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("portfolioREST");
    }

    public <T> T allPhotoCategory(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allPhotoCategory");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updatePhotoCategory(int categoryId, String categoryName, String description, String PhotoCategoryPath) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePhotoCategory/{0}/{1}/{2}/{3}", new Object[]{categoryId, categoryName, description, PhotoCategoryPath})).request().post(null);
    }

    public <T> T getAllPhotoCategory(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCategory");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T deletePhotoCategory(Class<T> responseType, int categoryId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("deletePhotoCategory/{0}", new Object[]{categoryId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPhotoCategoryById(Class<T> responseType, int categoryId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPhotoCategoryById/{0}", new Object[]{categoryId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addPhotoCategory(String PhotoCategoryName, String Description, String CategoryPath) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPhotoCategory/{0}/{1}/{2}", new Object[]{PhotoCategoryName, Description, CategoryPath})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
