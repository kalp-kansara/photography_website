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
 * Jersey REST client generated for REST resource:registrationREST
 * [registrationREST]<br>
 * USAGE:
 * <pre>
 *        registrationCLIENT client = new registrationCLIENT();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author KALP
 */
public class registrationCLIENT {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/photographyProject/webresources";

//    public registrationCLIENT() {
//        client = javax.ws.rs.client.ClientBuilder.newClient();
//        webTarget = client.target(BASE_URI).path("registrationREST");
//    }
    
        public registrationCLIENT(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("registrationREST");

        //  .queryParam("username", username)
        // .queryParam("password", password);
    }

    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {

            public boolean verify(String hostname,
                    javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("localhost")) {
                    return true;
                }
                return false;
            }
        });
    }


    public void RegistrationUser(String Email, String Password, String FirstName, String MiddleName, String LastName, String ProfilePhoto, String IsDisable) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("registration/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{Email, Password, FirstName, MiddleName, LastName, ProfilePhoto, IsDisable})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
