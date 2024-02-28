package main.controller;

import main.UserInterface;
import main.model.*;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Color.RED;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    private VehicleModel vModel;

    int gasAmount = 0;

    //A list of cars
    ArrayList<Vehicle> vehicleList;

    public CarController(VehicleModel vModel, UserInterface cView) {
        this.vehicleList = vModel.getVehicles();
        this.vModel = vModel;
    }

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }


    public ActionListener createGasActionListener() {
        return e -> gas(gasAmount);
    }

    public ActionListener createBrakeActionListener() {
        return e -> brake(gasAmount);
    }

    public ActionListener createStartActionListener() {
        return e -> startEngine();
    }

    public ActionListener createStopActionListener() {
        return e -> stopEngine();
    }

    public ActionListener createTurboOnActionListener() {
        return e -> turboOn();
    }

    public ActionListener createTurboOffActionListener() {
        return e -> turboOff();
    }

    public ActionListener createLiftBedActionListener() {
        return e -> liftBed();
    }

    public ActionListener createLowerBedActionListener() { return e -> lowerBed(); }

    public ActionListener createAddCarActionListener() { return e -> addCar(); }



    public ChangeListener createGasSpinnerChangeListener() {
        return e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue();
    }


    private void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getEngineOn()) {
                vehicle.gas(gas);
            }
        }
    }

    private void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicleList
        ) {
            vehicle.brake(brake);
        }
    }

    private void startEngine() {
        for (Vehicle vehicle : vehicleList
        ) {
            vehicle.startEngine();
        }
    }

    private void stopEngine() {
        for (Vehicle vehicle : vehicleList
        ) {
            vehicle.stopEngine();
        }
    }

    private void turboOn() {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Saab95) {
                Saab95 saab = (Saab95) vehicle; // evetuellt kanske i någon annan del av progemmet? början?
                saab.setTurboOn();
            }
        }
    }

    private void turboOff() {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Saab95) {
                Saab95 saab = (Saab95) vehicle; // evetuellt kanske i någon annan del av progemmet? början?
                saab.setTurboOff();
            }
        }
    }

    private void liftBed() {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Truck) { // Kontrollerar om vehicle är en instans av main.model.Truck
                Truck truck = (Truck) vehicle;
                truck.raise();
            }
        }
    }

    private void lowerBed() {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                truck.lower();
            }
        }
    }

    private void addCar() {
        // skapa en randomizer som genererar en siffra 1-3 och beroende på siffra skapa en viss typ av bil
        Vehicle v = new Volvo240(3, 100, RED, "nyVolvo"); // vet inte om vi vill ha detta i denna eller model, löser det inte med model
        vModel.addVehicle(v);
            }
    }






