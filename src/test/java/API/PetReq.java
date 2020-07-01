package API;

import API.POJO.PetPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class PetReq {
    @Test
    public  void  petReq() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();
        URIBuilder uriBuilder= new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.oi").setPath("/v2/pet");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
       // httpGet.setHeader("Content-Type","application/json");
        httpGet.setHeader("accept","application/json");
        HttpResponse response = client.execute(httpGet);
        ObjectMapper objectMapper=new ObjectMapper();
       PetPojo deserilizaedObject= objectMapper.readValue(response.getEntity().getContent(),
PetPojo.class);
        System.out.println(deserilizaedObject.getId());
        System.out.println(deserilizaedObject.getName());


    }

    @Test
    public  void test(){

    }
}
