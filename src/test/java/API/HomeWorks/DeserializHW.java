package API.HomeWorks;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class DeserializHW {
//    Deserialize response from https://api.chucknorris.io/jokes/random
//and print out the joke(value)

    //https://api.got.show/api/map/characters

    @Test
    public void deserializeResJoke() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("api.chucknorris.io");
        uriBuilder.setPath("jokes/random");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response = client.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserial = (Map<String, Object>) objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        deserial.get("value");
        System.out.println(deserial.get("value") + "Jokes");
    }

     //    Deserialize response from http://tronalddump.io/random/quote
    //    and print out the "value" and links.self.href
    @Test
    public void deserelizHomeWork() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("tronalddump.io");
        uriBuilder.setPath("random/quote");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response = client.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> val=objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        val.get("value");
        System.out.println(val.get("value")+"value");
        Map<String ,Object>links =(Map<String ,Object>)val.get("_links");
        System.out.println("Links "+links.get("self"));




    }
}
