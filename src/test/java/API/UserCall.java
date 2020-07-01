package API;

import API.POJO.UsersPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class UserCall {
    @Test
    public  void getUser() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users/7");
        HttpGet get= new HttpGet(uriBuilder.build());

        HttpResponse response = client.execute(get);
        ObjectMapper objectMapper=new ObjectMapper();
       UsersPojo deserResponse= objectMapper.readValue(response.getEntity()
       .getContent(),UsersPojo.class);

        System.out.println(deserResponse.getData().getFirst_name());
        System.out.println(deserResponse.getData().getLast_name());

    }
}
