package src.main.model;

import java.util.ArrayList;

public class VehicleModel {
    private final VehicleList vehicleList;

    public VehicleModel(){
        this.vehicleList = new VehicleList();
    }

    public void addVehicle(Vehicle v){
        vehicleList.addCar(v);
        //notify listners

    }

    public ArrayList<Vehicle> getVehicles(){return vehicleList.getVehicles();
    }

}
