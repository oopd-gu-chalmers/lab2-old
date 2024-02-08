
import src.CarRepairShop;
import src.Volvo240;
import src.Saab95;
import src.Scania;


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
    ShopWrapper shopWrapper;
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

        CarRepairShop<Volvo240> shop = new CarRepairShop<Volvo240>(3, 300,0);
        cc.shopWrapper = new ShopWrapper(shop);

        cc.cars.add(volvoWrapper);
        cc.cars.add(saabWrapper);
        cc.cars.add(scaniaWrapper);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        cc.frame.drawPanel.addItems(volvoWrapper);
        cc.frame.drawPanel.addItems(saabWrapper);
        cc.frame.drawPanel.addItems(scaniaWrapper);
        cc.frame.drawPanel.addItems(cc.shopWrapper);

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
                vehichle.moveit();
                if (vehichle.getVehicle() instanceof Volvo240 && shopWrapper.getShop().loadable((Volvo240) vehichle.getVehicle())) {
                    shopWrapper.getShop().loadCar((Volvo240) vehichle.getVehicle());
                }
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
    void turboOn() {
        Saab95 saab;
        for (VehichleWrapper car : cars) {
            if (car.getVehicle() instanceof Saab95) {
                saab = (Saab95) car.getVehicle();
                saab.setTurboOn();
            }
        }
    }
    void turboOff() {
        Saab95 saab;
        for (VehichleWrapper car : cars) {
            if (car.getVehicle() instanceof Saab95) {
                saab = (Saab95) car.getVehicle();
                saab.setTurboOff();
            }
        }
    }
    void liftPlatform() {
        Scania scania;
        for (VehichleWrapper car : cars) {
            if (car.getVehicle() instanceof Scania) {
                scania = (Scania) car.getVehicle();
                scania.raisePlatform();
            }
        }
    }
    void lowerPlatform() {
        Scania scania;
        for (VehichleWrapper car : cars) {
            if (car.getVehicle() instanceof Scania) {
                scania = (Scania) car.getVehicle();
                scania.lowerPlatform();
            }
        }
    }
    public void checkInBounds(int x, int y){
        for (VehichleWrapper car : cars) {
            if (car.getVehicle().getX()>x-100 || car.getVehicle().getX()<0 || car.getVehicle().getY()>y+200 || car.getVehicle().getY()<-5) {
                car.getVehicle().flipDirection();
            }
        }
    }
}
