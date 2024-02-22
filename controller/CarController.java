package controller;

import model.components.*;
import view.CarView;

import javax.swing.*;
import java.awt.*;
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
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    //A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    ServiceShop<Volvo240> volvoServiceShop = new ServiceShop<>(5);


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.volvoServiceShop.setXPos(0);
        cc.volvoServiceShop.setYPos(300);

        Volvo240 volvo = new Volvo240(4, 100, Color.BLACK, "ILoveVolvo");
        cc.vehicles.add(volvo);

        Saab95 saab = new Saab95(4,50,Color.RED,"ILoveSaab",true);
        cc.vehicles.add(saab);
        saab.setXPos(0);
        saab.setYPos(100);

        Scania scania = new Scania(2, 100, Color.BLUE, "ILoveScania");
        cc.vehicles.add(scania);
        scania.setXPos(0);
        scania.setYPos(200);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                checkAndCorrectPosition(vehicle);
                vehicle.move();
                checkCollision(vehicle);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }

        }}


        private void checkAndCorrectPosition(Vehicle vehicle) {
            int maxX = frame.drawPanel.getWidth();
            int maxY = frame.drawPanel.getHeight();

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
    }

    private void checkCollision(Vehicle vehicle) {
        //serviceShop.getClass().getGenericSuperclass().equals(car.getClass())
        if (vehicle.currentSpeed != 0){
            if (Math.abs(vehicle.getXPos() - volvoServiceShop.getXPos()) < 5 && Math.abs(vehicle.getYPos() - volvoServiceShop.getYPos()) < 5){
                if (vehicle instanceof Volvo240) {
                    Volvo240 volvo = (Volvo240) vehicle;
                    volvoServiceShop.load(volvo);
                    volvo.stopEngine();
                }
            }
        }
    }



}


        ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                carC.gas(gasAmount);

            }
        });

        brakeButton.addActionListener(new

        ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                carC.brake(gasAmount);

            }
        });

        startButton.addActionListener(new

        ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                carC.startEngine();

            }
        });

        stopButton.addActionListener(new

        ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                carC.stopEngine();
            }
        });
        turboOnButton.addActionListener(new

        ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                carC.turboOn();

            }
        });
        turboOffButton.addActionListener(new

        ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                carC.turboOff();

            }
        });
        liftBedButton.addActionListener(new

        ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                carC.liftBed();

            }
        });

        lowerBedButton.addActionListener(new

        ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                carC.lowerBed();

            }
        });

    }
    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
                ) {
            if (vehicle.engineOn){
                vehicle.gas(gas);}
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.brake(brake);
        }
    }

    void startEngine() {
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.stopEngine();
        }
    }

    void turboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                Saab95 saab = (Saab95) vehicle; // evetuellt kanske i någon annan del av progemmet? början?
                saab.setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                Saab95 saab = (Saab95) vehicle; // evetuellt kanske i någon annan del av progemmet? början?
                saab.setTurboOff();
            }
        }
    }
    void liftBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) { // Kontrollerar om vehicle är en instans av model.components.Truck
                Truck truck = (Truck) vehicle;
                truck.raise();
            }
        }
    }
    void lowerBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                truck.lower();
            }
        }
    }

}


