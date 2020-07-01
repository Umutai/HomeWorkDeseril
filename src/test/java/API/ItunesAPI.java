package API;

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
import java.util.List;
import java.util.Map;


public class ItunesAPI {
//    public void getArtist () throws URISyntaxException, IOException {
//       int  limitValue=100;
//        HttpClient client = HttpClientBuilder.create().build();
//        URIBuilder uriBuilder = new URIBuilder();
//        uriBuilder.setScheme("https");
//        uriBuilder.setHost("itunes.apple.com").setPath("search").setCustomQuery("term=Imagine Dragons="+limitValue);
//        HttpGet httpGet = new
//                HttpGet(uriBuilder.build());
//        httpGet.setHeader("Accept", "application/json");
//        HttpResponse response = client.execute(httpGet);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, Object> mapper =
//                objectMapper.readValue(response.getEntity().getContent(),
//                        new TypeReference<Map<String, Object>>() {
//                        });
//        List<Map<String,Object>>data=( List<Map<String,Object>>)mapper.get("results");
//        for (Map<String,Object>n:data){
//            String temp= "" +n.get("artistName");
//            Assert.assertTrue(temp.contains("Imagine Dragons"));
//
//        }
//        Assert.assertEquals(limitValue,data.size());
//        Assert.assertEquals(limitValue,mapper.get("resultCount"));
//
//    }
@Test
public void getLPark() throws URISyntaxException, IOException {
    int limitVAlue = 0;
    HttpClient client = HttpClientBuilder.create().build();
    URIBuilder uri = new URIBuilder();
    uri.setScheme("https");
    uri.setHost("itunes.apple.com");
    uri.setPath("search");
    uri.setCustomQuery("?term=linkinpark&limit" + limitVAlue);
    HttpGet get = new HttpGet(uri.build());
    HttpResponse response = client.execute(get);
    get.addHeader("Accept", "application/json");
    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> parseResponse = mapper.readValue(response.getEntity().getContent(),
            new TypeReference<Map<String, Object>>() {
            });
    List<Map<String, Object>> text = (List<Map<String, Object>>) parseResponse.get("results");
    int count = 0;
    for (Map<String, Object> n : text) {
        String temp = "" + n.get("artistName");
        count++;
        System.out.println(count);
        Assert.assertTrue(temp.contains("LINKIN PARK"));
    }
    System.out.println(limitVAlue);
    Assert.assertEquals(limitVAlue, text.size());
    //   Assert.assertEquals(limitVAlue, mapper.get("resultCount"));
  }
}
