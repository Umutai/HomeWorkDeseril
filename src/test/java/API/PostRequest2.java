package API;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import static Utils.PayLoadUtils.getPayLoad;

public class PostRequest2 {
    /*
    Create a path
    vrify new pets id ,name, status
     */
    @Test
    public void createPet() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");

        HttpPost post = new HttpPost(uriBuilder.build());
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Accept", "application/json");
        String name = "hatiko";

        String status = "waiting";
        int id = 1956;
        HttpEntity entity = new StringEntity(getPayLoad(id, name, status));
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        System.out.println("Finished post method execution ");
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        ObjectMapper objectMapper = new
                ObjectMapper();
        Map<String, Object> parseRespones = objectMapper.readValue(response.getEntity().getContent(),
                new
                        TypeReference<Map<String,Object>>() {
                        });
        int actualId = (int) parseRespones.get("id");
        String act = parseRespones.get("name").toString();
        String actStatus = parseRespones.get("status").toString();
        Assert.assertEquals(id,actualId);
        Assert.assertEquals(name,act);
        Assert.assertEquals(status,actStatus);

        // Execute Get Requset and do vrify

        uriBuilder.setPath("v2/pet/"+id);
        HttpGet get = new HttpGet(uriBuilder.build());
        HttpResponse getResponse =client.execute(get);
        Assert.assertEquals(HttpStatus.SC_OK,getResponse.getStatusLine().getStatusCode());
        Map<String,Object> parseResponse=objectMapper.readValue(getResponse.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        Assert.assertEquals(id,parseResponse.get("id"));
        Assert.assertEquals(name,parseResponse.get("name"));
        Assert.assertEquals(status,parseResponse.get("status"));





    }


}
