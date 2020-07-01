package API.Serisilation;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class carSeriziltaion {
//     @Test
//    public  void  seriz(){
//
//         Car car = new Car("BMV",2020,5000);
//         ObjectMapper.writeValue(new File("target/car.json"),car);
//
//
//     }
     @Test
    public  void createPet () throws URISyntaxException, IOException {
         HttpClient client= HttpClientBuilder.create().build();
         URIBuilder uriBuilder= new URIBuilder();
         uriBuilder.setScheme("https").setHost("petstore.swagger.oi").setPath("/v2/pet");
         HttpPost  post = new HttpPost(uriBuilder.build());
         post.setHeader("Content-Type","application/json");
         post.setHeader("accept","application/json");

         String petPayload = new String(Files.readAllBytes(Paths.get("target/pet.json")));
         HttpEntity entity= new StringEntity(petPayload);
         post.setEntity(entity);
         HttpResponse response= client.execute(post);
         Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());

     }

}
