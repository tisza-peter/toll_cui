package com.example.toll_cui.listvignettaforvehicle.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleModel {
    private String registrationNumber;
    private VehicleType vehicleCategory;
    private String make;
    private String model;
    private Integer numberOfSeats;

    private List<OwnerModel> owners;
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleType getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleType vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<OwnerModel> getOwners() {
        return owners;
    }

    public void setOwners(List<OwnerModel> owners) {
        this.owners = owners;
    }

    public void setByJson(JSONObject vehicleResponseModelJSON) {
        System.out.println(vehicleResponseModelJSON.toString());
        try {

            this.model= (String) vehicleResponseModelJSON.get("Model");
            this.make= (String) vehicleResponseModelJSON.get("Make");
            this.registrationNumber= (String) vehicleResponseModelJSON.get("RegistrationNumber");
            this.vehicleCategory= VehicleType.valueOf((String) vehicleResponseModelJSON.get("VehicleCategory")) ;
            this.numberOfSeats= (Integer) vehicleResponseModelJSON.get("NumberOfSeats");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, String> getViewModel() {
        Map<String, String> vehicleDatas = new HashMap<>();
        vehicleDatas.put("registrationNumber",this.getRegistrationNumber());
        vehicleDatas.put("make",this.getMake());
        vehicleDatas.put("model",this.getModel());
        vehicleDatas.put("numberOfSeats",Integer.toString(this.getNumberOfSeats()));
        vehicleDatas.put("vehicleType",this.getVehicleCategory().name());
        return vehicleDatas;
    }
}
