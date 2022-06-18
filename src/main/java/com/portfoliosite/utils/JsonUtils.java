package com.portfoliosite.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    public static <T>Object JsonToObject(String json, Class<?> objectClass){
        Object jsonGithub;

        var reader = new ObjectMapper()
                .readerForListOf(objectClass);

        try {
            jsonGithub = reader.readValue(json);
        } catch (Exception ex){
            jsonGithub = null;
        }

        return jsonGithub;
    }

    public static String ObjectToJson(Object objectJson) throws JsonProcessingException {
        return new ObjectMapper()
                .writeValueAsString(objectJson);
    }
}
