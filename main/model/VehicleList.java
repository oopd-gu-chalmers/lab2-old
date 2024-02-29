package main.model;

import java.util.ArrayList;

public class VehicleList {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addCar (Vehicle v) {
        if (vehicles.size() < 10) {
            vehicles.add(v);
        } else
            throw new IllegalStateException("Can't add more cars, the total number off cars has exceeded.");
    }

    public void removeCar(){
        if (!vehicles.isEmpty()){
        vehicles.remove(vehicles.size()-1);}
        else
          throw new IllegalStateException("Cannot remove car, no cars in game.");
    }

    public ArrayList<Vehicle> getVehicleList(){
        return vehicles;
    }


}
