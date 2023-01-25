package com.example.toll_cui.listvignettaforvehicle.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OwnerModel {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setByResponseModel(JSONObject ownerObject) {
        try {
            this.name = (String) ownerObject.get("Name");
            this.address = (String) ownerObject.get("Address");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, String> getViewModel() {
        Map<String, String> ownerDatas;
            ownerDatas = new HashMap<>();
            ownerDatas.put("name",this.getName());
            ownerDatas.put("address",this.getAddress());
        return ownerDatas;
    }
}
