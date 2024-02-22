package model;

import model.components.Vehicle;

import java.util.ArrayList;

public class VehicleList {
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addCar (Vehicle v){
        vehicles.add(v);
    }
}
