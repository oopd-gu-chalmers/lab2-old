import javax.swing.*;
import java.util.ArrayList; 
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

 //yeet

public class CarController {
    // member fields:
    ArrayList<Vehicle> cars = new ArrayList<>();
    Workshop<Volvo240> workshop = new Workshop<Volvo240>(500, 0, 2);  
    //methods:
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.frame.drawPanel.loadWorkshop(cc.workshop);
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
  
    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars)
        {
            try {
                car.gas(gas);
            } catch(Exception IllegalStateException) {
                continue;
            }
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars)
        {
            car.brake(brake);
        }
    }

    void startEngines() {
        for (Vehicle car : cars)
        {
            car.startEngine();
        }
    }

    void stopEngines() {
        for (Vehicle car : cars)
        {
            car.stopEngine();
        }
    }

    void saabTurboOn() {
        for (Vehicle car : cars)
        {
            if (car instanceof Saab95){
                Saab95 saab = (Saab95) car;
                saab.setTurboOn();
            }    
        }
    }

    void saabTurboOff() {
        for (Vehicle car : cars)
        {
            if (car instanceof Saab95){
                Saab95 saab = (Saab95) car;
                saab.setTurboOff();
            }    
        }
    }

    void PlatformDown() {
        for (Vehicle car : cars)
        {
            if (car instanceof TiltablePosterior){
                TiltablePosterior tiltable = (TiltablePosterior) car;
                tiltable.lowerTilt();
            }    
        }
    }

    void PlatformUp() {
        for (Vehicle car : cars)
        {
            if (car instanceof TiltablePosterior){
                TiltablePosterior tiltable = (TiltablePosterior) car;
                tiltable.raiseTilt();
            }    
        }
    }

    void checkForCollisionWithWorkshop() {
        for (Vehicle car : cars) {
            double car_x = car.getCurrentPos()[0] + frame.drawPanel.volvoImage.getWidth() / 2; //VolvoImage not optimal, but easiest. should define constant for image size.
            double car_y = car.getCurrentPos()[1] + frame.drawPanel.volvoImage.getHeight() / 2;
            double workshop_x = workshop.getCurrentPos()[0] + frame.drawPanel.volvoWorkshopImage.getWidth() / 2; //Same here.
            double workshop_y = workshop.getCurrentPos()[1] + frame.drawPanel.volvoWorkshopImage.getHeight() / 2;
            double distance = Math.sqrt(Math.pow(workshop_x - car_x, 2) + Math.pow(workshop_y - car_y, 2));
            if (car instanceof Volvo240) {
                workshop.load((Volvo240) car);
                if (workshop.getCurrentLoad().contains(car)) {
                    car.stopEngine();
                }
            }
        }
    }

    void moveAllCars(){
        for (Vehicle car : cars){
            car.move();
        }
    }
    void checkForCollisionWithBorder(){
        for (Vehicle car: cars){
        if (car.getCurrentPos()[0] + frame.drawPanel.volvoImage.getWidth() >= frame.getPreferredSize().getWidth()){ // frame.drawPanel.volvoImage volvoImage is very hard coded change!
            car.setDirection(car.getDirection() + 180);
        } else if (car.getCurrentPos()[0] < 0) {
            car.setDirection(car.getDirection() - 180);
        }
    }
    }
}
