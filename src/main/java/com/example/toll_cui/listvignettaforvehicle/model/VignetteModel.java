package com.example.toll_cui.listvignettaforvehicle.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class VignetteModel {

    private Boolean valid;
    private Date validFrom;
    private Date validTo;
    private String vehicleCategoryOfVignette;
    private Date dateOfPurchase;

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getVehicleCategoryOfVignette() {
        return vehicleCategoryOfVignette;
    }

    public void setVehicleCategoryOfVignette(String vehicleCategoryOfVignette) {
        this.vehicleCategoryOfVignette = vehicleCategoryOfVignette;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }


    public void setByResponseModel(JSONObject vignetteObject) {
        try {
            this.dateOfPurchase = new SimpleDateFormat("yyyy-MM-dd").parse((String) vignetteObject.get("DateOfPurchase"));
            this.valid = (Boolean) vignetteObject.get("Valid");
            this.validFrom = new SimpleDateFormat("yyyy-MM-dd").parse((String)vignetteObject.get("ValidFrom"));
            this.validTo = new SimpleDateFormat("yyyy-MM-dd").parse((String) vignetteObject.get("ValidTo"));
            this.vehicleCategoryOfVignette = (String) vignetteObject.get("VehicleCategoryOfVignette");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, String> getViewModel() {
        Map<String, String> vignetteDatas;
            vignetteDatas = new HashMap<>();
            vignetteDatas.put("VehicleCategoryOfVignette",this.getVehicleCategoryOfVignette());
            vignetteDatas.put("Valid", String.valueOf(this.getValid()));
            vignetteDatas.put("DateOfPurchase", convertDateToString(this.getDateOfPurchase()));
            vignetteDatas.put("ValidFrom", convertDateToString(this.getValidFrom()));
            vignetteDatas.put("ValidTo", convertDateToString(this.getValidTo()));
        return vignetteDatas;
    }

    public static String convertDateToString(Date date)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateToString = df.format(date);
        return (dateToString);
    }

}
