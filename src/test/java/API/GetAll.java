package API;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetAll {
    @Test
    public void  getHouses() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("api.got.show");
        uriBuilder.setPath("api/map/characters");
        HttpGet get= new HttpGet(uriBuilder.build());

        HttpResponse response = client.execute(get);
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String ,Object> parseResponse =objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String,Object>>() {
                });
        List<Map <String,Object>> dataValues=(List<Map<String,Object>>)parseResponse.get("data");
        Map<String,Object>firstHouse =dataValues.get(0);
        System.out.println(firstHouse.get("house"));


    }
}
