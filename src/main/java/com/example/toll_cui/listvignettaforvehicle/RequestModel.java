package com.example.toll_cui.listvignettaforvehicle;

import org.json.JSONException;
import org.json.JSONObject;

public class RequestModel {

    public String registrationNumber;

    public JSONObject getJson() {
        JSONObject result = new JSONObject();
        try {
            result.put("registrationNumber",registrationNumber);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
