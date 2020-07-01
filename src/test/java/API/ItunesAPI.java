package apiday1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.net.URIBuilder;
import org.junit.Assert;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class ItunesAPI {
    public void getArtist () throws URISyntaxException, IOException {
       int  limitValue=100;
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("itunes.apple.com").setPath("search").setCustomQuery("term=Imagine Dragons="+limitValue);
        HttpGet httpGet = new
                HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response = client.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> mapper =
                objectMapper.readValue(response.getEntity().getContent(),
                        new TypeReference<Map<String, Object>>() {
                        });
        List<Map<String,Object>>data=( List<Map<String,Object>>)mapper.get("results");
        for (Map<String,Object>n:data){
            String temp= "" +n.get("artistName");
            Assert.assertTrue(temp.contains("Imagine Dragons"));

        }
        Assert.assertEquals(limitValue,data.size());
        Assert.assertEquals(limitValue,mapper.get("resultCount"));

    }
}
