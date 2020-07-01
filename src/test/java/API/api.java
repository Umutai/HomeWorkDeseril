package apiday1;



import org.apache.hc.client5.http.classic.HttpClient;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.net.URIBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class api {
    //    To send a API call :
//            1. open a client (postman ,terminal)
//  2. Specify the HTTP method (Get,Post)
//  3. Specify URL/URI endpoint
//  4. Add query parameter (if needed)
//  5. Add header  parameters (CONTENT-TYPE,accept)
//  6. Add body paameter (for POST)
//  7 .
    @Test
    public void getRequest() throws IOException, URISyntaxException {
        //open a client
        HttpClient client = HttpClientBuilder.create().build();
        //specify  the Http method (GET)
        // HttpGet get = new HttpGet();
        //specify URL/URI/endpoints
        //https://petstore.swagger.io/v2/pet/{petId}
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("petstore.swagger.io");
        uri.setPath("v2/pet/7890");

        //Specify  the Http method (get)
        HttpGet get = new HttpGet(uri.build());
        //Add header parameters
        get.setHeader("Accept", "application/json");
        //execute
        HttpResponse response = client.execute(get);
        System.out.println("status code for get request is:" +
                response.getStatusLine().getStatusCode());
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        Assert.assertEquals("application/json", response.getEntity().getContentType().getValue());

    }
@Test
    public  void getRequest2() throws URISyntaxException, IOException {
        // execute a GET request to :
    //http://petstore.swagger.io/v2/pet/findByStatus?status=sold
    HttpClient client = HttpClientBuilder.create().build();
    URIBuilder uri = new URIBuilder();
    uri.setScheme("https");
    uri.setHost("petstore.swagger.io");
    uri.setPath("v2/pet/findByStatus");
    uri.setCustomQuery("status-sold");
    HttpGet httpGet = new HttpGet(uri.build());
    //Add header parameters
    httpGet.setHeader("Accept", "application/json");
    HttpResponse response = client.execute(httpGet);
    Assert.assertEquals(200, response.getStatusLine().getStatusCode());
    Assert.assertEquals("application/json", response.getEntity().getContentType().getValue());

}

}
