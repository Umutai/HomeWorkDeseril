package apiday1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class CatFacts {
    @Test
    public void countCatFacts() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("cat-fact.herokuapp.com");
        uriBuilder.setPath("facts");
        HttpGet get = new HttpGet(uriBuilder.build());
        HttpResponse response = client.execute(get);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List> parsedResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, List>>() {
                });
        parsedResponse.get("all");
        System.out.println(parsedResponse.get("all").size());
    }
    @Test
    public void countNotCatFacts() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("cat-fact.herokuapp.com");
        uriBuilder.setPath("facts");
        HttpGet get = new HttpGet(uriBuilder.build());
        HttpResponse response = client.execute(get);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List<Map<String, Object>>> parsedResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, List<Map<String, Object>>>>() {
                });
        System.out.println(parsedResponse.get("all").get(0).get("text"));
        List<Map<String, Object>> mapList = parsedResponse.get("all");
        for (Map<String, Object> map :
                mapList) {
            System.out.println(map.get("text"));
            Map<String, Object> userInfo = (Map<String, Object>) map.get("user");
            Map<String, String> firstNLastName = (Map<String, String>) userInfo.get("name");
            firstNLastName.get("first");
            firstNLastName.get("last");
        }
    }
    @Test
    public void userApi() throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("regres.in");
        uriBuilder.setPath("api/uers/");
        HttpGet get = new HttpGet(uriBuilder.build());
        HttpResponse response = client.execute(get);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> usersInfo = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        System.out.println(usersInfo.get("page") + "" + usersInfo.get("per_page"));
        System.out.println("per_page");
        System.out.println("total");
        System.out.println("total_pages");
//Integer inter = new Integer(123);
        List<Map<String, Object>> users = (List<Map<String, Object>>) usersInfo.get("data");
        // System.out.println(users);
        for(int b=0;b<users.size();b++){
            System.out.println(users.get(b).get("first_name"));
        }
    }
}
