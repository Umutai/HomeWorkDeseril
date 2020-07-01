package apiday1;

import Utils.PostUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.net.URISyntaxException;

public class PostNewCars  {
    @Test
    public void createNewDogs() throws URISyntaxException, IOException {
        for(int i=0; i<=25; i++) {
            HttpClient client1 = HttpClientBuilder.create().build();
            URIBuilder uriBuilder1 = new URIBuilder();
            uriBuilder1.setScheme("https");
            uriBuilder1.setHost("petstore.swagger.io");
            uriBuilder1.setPath("v2/pet");
            HttpPost post2 = new HttpPost(uriBuilder1.build());
            post2.setHeader("Content-Type", "application/json");
            post2.setHeader("Accept", "application/json");
            HttpEntity entity = new StringEntity(PostUtils.getPOSTLoad());
            post2.setEntity(entity);
            HttpResponse response = client1.execute(post2);
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        }
    }
}

