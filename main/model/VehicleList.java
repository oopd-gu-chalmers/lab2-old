package main.model;

import java.util.ArrayList;

public class VehicleList {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addCar (Vehicle v){
        vehicles.add(v);
    }

    public ArrayList<Vehicle> getVehicles(){
        return vehicles;
    }


}
