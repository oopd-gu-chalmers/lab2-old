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
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Saab95> saabList = new ArrayList<>(); //should actually be has turbo interface
    ArrayList<Scania> scaniaList = new ArrayList<>(); // should actually be has ramp interface


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();



        Saab95 saab95 = new Saab95(0,100,10,100,0,Color.black, "Saab95",90);
        Scania scania = new Scania(0,200,2,300,0,Color.blue,"Scania", 90);

        cc.vehicles.add(new Volvo240(0, 0, 4, 100, 0, Color.red, "Volvo240", 90));
        cc.vehicles.add(saab95);
        cc.vehicles.add(scania);

        cc.saabList.add(saab95);
        cc.scaniaList.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        cc.frame.drawPanel.vehicles = cc.vehicles;


        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                /*
                Assuming each image has x(width) = 100, and y(height) = 60.
                The green frame they're in has the dimensions x = 784 X 560 = y.
                I'm really not sure about these numbers, gotten from trial and error.
                 */

                vehicle.move();
               // int x = (int) Math.round(vehicle.getX());
                //int y = (int) Math.round(vehicle.getY());


                //frame.drawPanel.moveit(x, y);


                if (isOutOfBoundsDown(vehicle)) {
                    //frame.drawPanel.moveit(x, 500);
                    vehicle.setY(500);
                    vehicle.invertDirection();
                } else if (isOutOfBoundsUp(vehicle)) {
                    //frame.drawPanel.moveit(x, 0);
                    vehicle.setY(0);
                    vehicle.invertDirection();
                }

                if (isOutOfBoundsRight(vehicle)) {
                    //frame.drawPanel.moveit(684, y);
                    vehicle.setX(684);
                    vehicle.invertDirection();
                } else if (isOutOfBoundsLeft(vehicle)) {
                    //frame.drawPanel.moveit(0, y);
                    vehicle.setX(0);
                    vehicle.invertDirection();
                }


                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }



        }

        private boolean isOutOfBoundsLeft(Vehicle car) {
            return car.getX() < 0;
        }

        private boolean isOutOfBoundsRight(Vehicle car) {
            return car.getX() > 684;
        }

        private boolean isOutOfBoundsUp(Vehicle car) {
            return car.getY() < 0;
        }

        private boolean isOutOfBoundsDown(Vehicle car) {
            return car.getY() > 500;
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.brake(gas);
        }
    }

    public void turboOn() {
        for(Saab95 saab: saabList) {
            saab.setTurboOn();
            //saab.stopEngine();
        }
    }

    public void turboOff() {
        for(Saab95 saab: saabList) {
            saab.setTurboOff();
        }
    }

    public void liftBed() {
      for(Scania scania: scaniaList) {
          scania.raisePlatformAngle(60);
      }
    }

    public void lowerBed() {
        for(Scania scania: scaniaList) {
            scania.lowerPlatformAngle(60);
        }
    }

    public void startAllVehicles() {
        for(Vehicle vehicle: vehicles) {
            vehicle.startEngine();
        }
    }

    public void stopAllVehicles() {
        for(Vehicle vehicle: vehicles) {
            vehicle.stopEngine();
        }
    }

}
