package com.example.toll_cui.listvignettaforvehicle;

import com.example.toll_core.listvignettaforvehicle.api.VehicleWithVignettesResponsePresenter;
import com.example.toll_cui.TollSystemView;
import com.example.toll_cui.listvignettaforvehicle.model.OwnerModel;
import com.example.toll_cui.listvignettaforvehicle.model.VehicleModel;
import com.example.toll_cui.listvignettaforvehicle.model.VignetteModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Presenter implements VehicleWithVignettesResponsePresenter {


    private TollSystemView myView=null;

    public void setView(TollSystemView view)
    {
        myView=view;
    }
    @Override
    public void DisplayOneVehicleWithVignettes(String getVehicleWithVignettesResponseModelJSON) {
        VehicleModel vem = getVehicleFromJSON(getVehicleWithVignettesResponseModelJSON);
        myView.printVehicle(vem);

        List<VignetteModel> vim = getVignettaFromJSON(getVehicleWithVignettesResponseModelJSON);
        myView.printVignettes(vim);

        List<OwnerModel> om = getOwnersFromJSON(getVehicleWithVignettesResponseModelJSON);
        myView.printOwners(om);
    }

    private VehicleModel getVehicleFromJSON(String getVehicleWithVignettesResponseModelJSON) {
        ResponseModel result=new ResponseModel();
        try {
            JSONObject rootObject=new JSONObject(getVehicleWithVignettesResponseModelJSON);
            VehicleModel vehicle = new VehicleModel();
            vehicle.setByJson((JSONObject) rootObject.get("vehicle"));
            return vehicle;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private List<OwnerModel> getOwnersFromJSON(String getVehicleWithVignettesResponseModelJSON) {
        try {
            JSONObject rootObject=new JSONObject(getVehicleWithVignettesResponseModelJSON);
            List<OwnerModel> owners = new ArrayList<>();
            JSONArray ownersObject = (JSONArray) rootObject.get("owners");
            for (int i = 0; i < ownersObject.length(); i++) {
                JSONObject ownerObject = (JSONObject) ownersObject.get(i);
                OwnerModel owner=new OwnerModel();
                owner.setByResponseModel(ownerObject);
                owners.add(owner);
            }
            return owners;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private List<VignetteModel> getVignettaFromJSON(String getVehicleWithVignettesResponseModelJSON) {
        try {
            JSONObject rootObject=new JSONObject(getVehicleWithVignettesResponseModelJSON);

            List<VignetteModel> vignettes=new ArrayList<>();
            JSONArray vignettesObject = (JSONArray) rootObject.get("vignettes");

            for (int i = 0; i < vignettesObject.length(); i++) {
                JSONObject vignetteObject = (JSONObject) vignettesObject.get(i);
                VignetteModel vignette=new VignetteModel();
                vignette.setByResponseModel(vignetteObject);
                vignettes.add(vignette);
            }
            return vignettes;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }



}
