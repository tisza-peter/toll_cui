package com.example.toll_cui.listvignettaforvehicle;


import com.example.toll_core.listvignettaforvehicle.ListOfVehicleWithVignettes;

public class Controller {
    ListOfVehicleWithVignettes tollCore;

    public void SetCore(ListOfVehicleWithVignettes core)
    {
        tollCore=core;
    }

    public void sendRequest(RequestModel model)
    {
        tollCore.listOfVehicleWithVignettes(model.getJson().toString());
    }

}
