package main.controller;

import main.UserInterface;
import main.model.*;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import static java.awt.Color.*;

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
        addListeners(cView);
    }

    private void addListeners(UserInterface ui){
        // Add listeners
        ui.addGasButtonListener(createGasActionListener());
        ui.addBrakeButtonListener(createBrakeActionListener());
        ui.addStartButtonListener(createStartActionListener());
        ui.addStopButtonListener(createStopActionListener());
        ui.addTurboOnButtonListener(createTurboOnActionListener());
        ui.addTurboOffButtonListener(createTurboOffActionListener());
        ui.addLiftBedButtonListener(createLiftBedActionListener());
        ui.addLowerBedButtonListener(createLowerBedActionListener());
        ui.addAddCarButtonListener(createAddCarActionListener());
        ui.addGasSpinnerListener(createGasSpinnerChangeListener());
        ui.addRemoveCarButtonListener(createremoveCarActionListener());
        ui.addTurnLeftButtonListener(createTurnLeftActionListener());
        ui.addTurnRightButtonListener(createTurnRightActionListener());
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

    public ActionListener createremoveCarActionListener() { return e -> removeCar(); }

    public ActionListener createTurnLeftActionListener() { return e -> turnLeft(); }

    public ActionListener createTurnRightActionListener() { return e -> turnRight(); }



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
//        Vehicle v = VehicleFactory.createVolvo240(3, 100, RED, "nyVolvo");
//        vModel.addCar(v);
        List<List<Object>> exampleVolvoList = new ArrayList<>();

        // Add elements to the list
        exampleVolvoList.add(List.of(1, 50, BLUE, "volvo1"));
        exampleVolvoList.add(List.of(2, 70, ORANGE, "volvo2"));
        exampleVolvoList.add(List.of(4, 80, PINK, "volvo3"));
        exampleVolvoList.add(List.of(2, 40, GREEN, "volvo4"));

        Random random = new Random();
        int randomNumber = random.nextInt(4);

        int nrDoors = (int) exampleVolvoList.get(randomNumber).get(0);
        double enginePower = (int) exampleVolvoList.get(randomNumber).get(1);
        Color color = (Color) exampleVolvoList.get(randomNumber).get(2);
        String name = (String) exampleVolvoList.get(randomNumber).get(3);


        Vehicle v = VehicleFactory.createVolvo240(nrDoors, enginePower, color, name);

        // skapa en randomizer som genererar en siffra 1-3 och beroende på siffra skapa en viss typ av bil
        //Vehicle v = new Volvo240(3, 100, RED, "nyVolvo"); // vet inte om vi vill ha detta i denna eller model, löser det inte med model
        v.setXPos(0);
        v.setYPos(0);
        vModel.addCar(v);
            }

    private void removeCar(){
        vModel.removeCar();
    }

    private void turnLeft() {
        for (Vehicle vehicle : vehicleList) {
            vehicle.turnLeft();
        }
    }

    private void turnRight() {
        for (Vehicle vehicle : vehicleList
        ) {
            vehicle.turnRight();
        }
    }
    }








