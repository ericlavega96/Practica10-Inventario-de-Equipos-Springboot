package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JsonTransformer {
    private Gson gson = new GsonBuilder().serializeNulls().create();

    public String toJson(Object object) {
        return gson.toJson(object);
    }

    public Map<String, Object> jsonToMap(String json) {
        Map<String, Object> map = gson.fromJson(json, new TypeToken<HashMap<String, Object>>() {
        }.getType());

        return map;
    }

    public JsonObject stringToJsonObject(String jsonString) {
        return new JsonParser().parse(jsonString).getAsJsonObject();
    }

    public JsonArray stringToJsonArray(String jsonString) {
        return new JsonParser().parse(jsonString).getAsJsonArray();
    }


}