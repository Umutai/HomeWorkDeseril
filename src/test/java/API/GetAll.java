package apiday1;





import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.Map;

public class GetAll {
    @Test
    public void  getHouses() throws URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("api.got.show");
        uriBuilder.setPath("api/map/characters");
        HttpGet = new HttpGet(uriBuilder.build());

        HttpResponse=client.execute(get);
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String ,Object> parseResponse =objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String,object>>() {
                });
        List<Map<String,Object>> dataValues=(   List<Map<String,Object>>)parseResponse.get("data");
        Map<String,Object>firstHouse =dataValues.get(0);
        System.out.println(firstHouse.get("house"));


    }
}
