package apiday1;

import org.apache.http.client.HttpClient;
import org.junit.Test;

import java.util.Map;

public class UserVerify {
    @Test
    public  void verifyUsers(){
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("api.got.show");
        uriBuilder.setPath("api/map/characters");
        HttpGet = new HttpGet(uriBuilder.build());

        HttpResponse=client.execute(get);
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String ,Object> deso =objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String,object>>() {
                });
        List<Map<String,Object>> dataValues=(List<Map<String,Object>>)deso.get("data");
        Map<String,Object>firstHouse =dataValues.get(0);
        System.out.println(firstHouse.get("house"));
    }
}
