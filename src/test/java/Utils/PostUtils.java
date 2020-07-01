package Utils;

import API.RandomPetName;

public class PostUtils {
    public static String getPOSTLoad() {
        Long id = System.currentTimeMillis();
        System.out.println(id);
        return
                "{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"" + RandomPetName.getPetName() + "\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"Sold\"\n" +
                        "}";
    }
}

