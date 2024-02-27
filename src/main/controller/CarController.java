package src.main.controller;

import src.main.UserInterface;
import src.main.model.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());

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

    public ActionListener createLowerBedActionListener() {
        return e -> lowerBed();
    }

    public ChangeListener createGasSpinnerChangeListener() {
        return e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue();
    }


    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getEngineOn()) {
                vehicle.gas(gas);
            }
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicleList
        ) {
            vehicle.brake(brake);
        }
    }

    void startEngine() {
        for (Vehicle vehicle : vehicleList
        ) {
            vehicle.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle vehicle : vehicleList
        ) {
            vehicle.stopEngine();
        }
    }

    void turboOn() {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Saab95) {
                Saab95 saab = (Saab95) vehicle; // evetuellt kanske i någon annan del av progemmet? början?
                saab.setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Saab95) {
                Saab95 saab = (Saab95) vehicle; // evetuellt kanske i någon annan del av progemmet? början?
                saab.setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Truck) { // Kontrollerar om vehicle är en instans av main.model.Truck
                Truck truck = (Truck) vehicle;
                truck.raise();
            }
        }
    }

    void lowerBed() {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                truck.lower();
            }
        }
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {     // Vad är syftet med denna???
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logik som ska utföras vid varje tick; till exempel:
            vModel.updateVehicles();
            // vModel.updateView(); /// repaint() på något sätt


        }
    }

//        public void actionPerformed(ActionEvent e) {
//            int maxX = cView.getDrawPanelWidth();
//            int maxY = cView.getDrawPanelHeight();
//            for (Vehicle vehicle : vehicleList) {
//                vehicle.move();
//            }

}



    /*private void checkAndCorrectPosition(Vehicle vehicle, int maxX, int maxY) {
        int x = (int) Math.round(vehicle.getXPos());
        int y = (int) Math.round(vehicle.getYPos());
        if (x < 0) {
            vehicle.setXPos(0);
            vehicle.setDirection(-vehicle.getDirection());
        }
        else if (x> maxX) {
            vehicle.setXPos(maxX);
            vehicle.setDirection(-vehicle.getDirection());
        }

        if (y < 0) {
            vehicle.setYPos(0);
            vehicle.setDirection(-vehicle.getDirection());
        }
        else if (y > maxY) {
            vehicle.setYPos(maxY);
            vehicle.setDirection(-vehicle.getDirection());
        }
    }*/

    /*private void checkCollision(Vehicle vehicle) {
        //serviceShop.getClass().getGenericSuperclass().equals(car.getClass())
        if (vehicle.getCurrentSpeed() != 0){
            if (Math.abs(vehicle.getXPos() - volvoServiceShop.getXPos()) < 5 && Math.abs(vehicle.getYPos() - volvoServiceShop.getYPos()) < 5){
                if (vehicle instanceof Volvo240) {
                    Volvo240 volvo = (Volvo240) vehicle;
                    volvoServiceShop.load(volvo);
                    volvo.stopEngine();
                }
            }
        }
    }*/


