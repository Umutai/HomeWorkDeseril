package API;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import static Utils.PayLoadUtils.getPayLoad;
public class POSTRequest {

    /*
To send API call:
1.Open a client (POSTMAN,terminal)
2.Specify the HTTP method (GET,POSt)
3.Specify URL/URIO/endpoint
4.Add query parameter (if need)
5.Add header parameter (content-type,accpet)
6.Add body parameter (for POST)
7.Execute (click on Send button)
*/
    @Test
    public void postRequest() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users");
        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Accept", "application.json");
        HttpEntity entityBuilder = new StringEntity("{\n" +
                "    \"name\": \"Emir\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");
        httpPost.setEntity(entityBuilder);
        HttpResponse response = httpClient.execute(httpPost);
        Assert.assertEquals(201, ((HttpResponse) response).getStatusLine().getStatusCode());
    }
    @Test
    public void createPet() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");
        HttpPost post = new HttpPost(uriBuilder.build());
        post.setHeader("Content-Type","application/json");
        post.setHeader("Accept","application/json");
        HttpEntity entity=new StringEntity(getPayLoad(123445,"REX","SOLD"));
        post.setEntity(entity);
        HttpResponse response=client.execute(post);
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());
    }
}

