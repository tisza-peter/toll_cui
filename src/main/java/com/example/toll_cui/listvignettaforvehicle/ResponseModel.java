package com.example.toll_cui.listvignettaforvehicle;

import com.example.toll_cui.listvignettaforvehicle.model.VehicleModel;
import com.example.toll_cui.listvignettaforvehicle.model.VignetteModel;

import java.util.List;

public class ResponseModel {
    private VehicleModel vehicle;
    private List<VignetteModel> vignettes;

    public VehicleModel getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleModel vehicle) {
        this.vehicle = vehicle;
    }

    public List<VignetteModel> getVignettes() {
        return vignettes;
    }

    public void setVignettes(List<VignetteModel> vignettes) {
        this.vignettes = vignettes;
    }
}
