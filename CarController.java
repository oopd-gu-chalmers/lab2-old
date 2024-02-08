import src.Car;
import src.Volvo240;
import src.Saab95;
import src.Scania;
import src.Vehichle;

import javax.swing.*;
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
    // A list of cars, modify if needed
    ArrayList<VehichleWrapper> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Scania scania = new Scania();
        saab.setLocation(0, 100);
        scania.setLocation(0, 200);
        VehichleWrapper volvoWrapper = new VehichleWrapper(volvo);
        VehichleWrapper saabWrapper = new VehichleWrapper(saab);
        VehichleWrapper scaniaWrapper = new VehichleWrapper(scania);

        cc.cars.add(volvoWrapper);
        cc.cars.add(saabWrapper);
        cc.cars.add(scaniaWrapper);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        cc.frame.drawPanel.addVehicles(volvoWrapper);
        cc.frame.drawPanel.addVehicles(saabWrapper);
        cc.frame.drawPanel.addVehicles(scaniaWrapper);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (VehichleWrapper vehichle : cars) {
                vehichle.getVehicle().move();
                checkInBounds(frame.getX(),frame.getY());
                int x = (int) Math.round(vehichle.getVehicle().getX());
                int y = (int) Math.round(vehichle.getVehicle().getY());
                frame.drawPanel.moveit(vehichle.getVehicle(), x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;for (VehichleWrapper car : cars
                ) {
            car.getVehicle().gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;for (VehichleWrapper car : cars
        ) {
            car.getVehicle().brake(brake);
        }
    }
    void startCars() {
        for (VehichleWrapper car : cars)
            car.getVehicle().startEngine();
    }
    void stopCars() {
        for (VehichleWrapper car : cars)
            car.getVehicle().stopEngine();
    }
    public void checkInBounds(int x, int y){
        for (VehichleWrapper car : cars) {
            if (car.getX()>x-100 || car.getX()<0 || car.getY()>y+200 || car.getY()<-5) {
                car.getVehicle().flipDirection();
            }
        }
    }
}
