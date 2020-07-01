package apiday1;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;



public class DeserializationIntro {
    @Test
    public void test1() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setPath("v2/pet/1");
        HttpPost httpGet= new HttpPost(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response=client.execute(httpGet);
        if(response.getStatusLine().getStatusCode() !=200){
            Assert.fail();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> desirilizedResponse =
                objectMapper.readValue(response.getEntity().getContent(),
                        new TypeReference<Map<String, Object>>() {
                        });
        System.out.println("the id " + desirilizedResponse.get("id"));
        System.out.println("the name " + desirilizedResponse.get("name"));
        Map<String, Object> category = (Map<String, Object>) desirilizedResponse.get("category");
        System.out.println("Category name " + category.get("name"));


    }

}



