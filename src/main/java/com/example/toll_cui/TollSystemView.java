package com.example.toll_cui;

import com.example.toll_cui.listvignettaforvehicle.Controller;
import com.example.toll_cui.listvignettaforvehicle.RequestModel;
import com.example.toll_cui.listvignettaforvehicle.model.OwnerModel;
import com.example.toll_cui.listvignettaforvehicle.model.VehicleModel;
import com.example.toll_cui.listvignettaforvehicle.model.VignetteModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TollSystemView {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Controller controller=null;

    public void Start()
    {
        String command;
        PrintAvailableCommands();
        do {
            command=GetCommand();
            if(command.equals("get"))
            {
                RequestModel model=new RequestModel();
                model.registrationNumber=GetRegistrationNumberFromConsole();
                controller.sendRequest(model);
            }
        }while (!command.equals("stop"));
    }
    public void PrintAvailableCommands() {
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to quit.");
        System.out.println("Enter 'set' to new vehicle adding.");
        System.out.println("Enter 'get' to new vehicle adding.");
    }
    public String GetCommand()  {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String GetRegistrationNumberFromConsole()  {
        System.out.println("Enter registration number of vehicle to read its data.");
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void printVehicle(VehicleModel ve) {
        System.out.println("vehicle datas is:");
        printMap(ve.getViewModel());
    }

    public void printVignettes(List<VignetteModel> vis) {
        System.out.println("vignettes datas is:");
        System.out.println("Number of vignettes is: "+Integer.toString(vis.size()));
        for (VignetteModel vi:vis) {
            printMap(vi.getViewModel());
        }
    }

    public void printOwners(List<OwnerModel> ows) {
        System.out.println("owners datas is:");
        System.out.println("Number of owners is: "+Integer.toString(ows.size()));
        for (OwnerModel ow:ows) {
            printMap(ow.getViewModel());
        }
    }




    private void printMap(Map<String, String> datas) {
        int keysMaxLength = maxLength(datas.keySet());
        int valuesMaxLength = maxLength(datas.values());
        System.out.print("/");
        System.out.print("-".repeat( keysMaxLength+valuesMaxLength+5));
        System.out.println("\\");
        for (Map.Entry<String, String> data:datas.entrySet()) {
            System.out.print("|");
            System.out.print(" ".repeat(1+keysMaxLength-data.getKey().length()));
            System.out.print(data.getKey());
            System.out.print(" | ");
            System.out.print(data.getValue());
            System.out.print(" ".repeat(1+valuesMaxLength-data.getValue().length()));
            System.out.println("|");
        }
        System.out.print("\\");
        System.out.print("-".repeat( keysMaxLength+valuesMaxLength+5));
        System.out.println("/");
    }


    public static int maxLength(Collection<String> strings) {
        if (strings == null)
            throw new NullPointerException("strings cannot be null");
        Iterator<String> i = strings.iterator();
        int max = 0;
        while (i.hasNext()) {
            String str = i.next();
            if (str != null) {
                int l = str.length();
                if (l > max) {
                    max = l;
                }
            }
        }
        return max;
    }


    public void SetController(Controller vehicleWithVignettesController) {
        controller=vehicleWithVignettesController;
    }
}
