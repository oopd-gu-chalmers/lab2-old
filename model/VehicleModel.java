package model;

import model.components.Vehicle;

public class VehicleModel {
    private final VehicleList vehicleList;

    public VehicleModel(){
        vehicleList = new VehicleList();
    }

    public void addVehicle(Vehicle v){
        vehicleList.addCar(v);
        //notify listners


    }

}
