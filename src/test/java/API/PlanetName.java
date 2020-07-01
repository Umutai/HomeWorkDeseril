package API;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class PlanetName {
    @Test
    public void getPlanets() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("swapi.dev");
        uri.setPath("api/planets");
        HttpGet get = new HttpGet((uri.build()));
        get.setHeader("Acctep", "application/json");
        HttpResponse response = client.execute(get);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> parseResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        List<Map<String, Object>> results = (List<Map<String, Object>>) parseResponse.get("results");
        Map<String, String> planetPopulation = new HashMap<>();
        for (int i = 0; i < results.size(); i++) {
            String planet = results.get(i).get("name").toString();
            String population=results.get(i).get("population").toString();

            planetPopulation.put(planet, population);


        }
        System.out.println(planetPopulation);

    }
}
