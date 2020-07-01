package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayLoadUtils {
    public static String getPayLoad(int id,String name,String status){
        return "{\n" +
                "  \"id\": \"" + id + "\",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \" " + name + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";
    }
    public  static String generateStringFromresource(String path) throws IOException {

        String petPayload = new String(Files.readAllBytes(Paths.get("target/pet.json")));
    return petPayload;
    }
}

