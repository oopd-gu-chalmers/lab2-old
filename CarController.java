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
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(4, 100, Color.BLACK, "ILoveVolvo"));

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
            int maxX = frame.drawPanel.getWidth();
            int maxY = frame.drawPanel.getWidth()-200;

            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getXPos());
                int y = (int) Math.round(car.getYPos());
                if (x < 0) {
                    x = 0;
                    car.setDirection(-car.getDirection());
                }
                else if (x> maxX) {
                    car.setXPos(maxX);
                    car.setDirection(-car.getDirection());
                }

                if (y < 0) {
                    y = 0;
                    car.setDirection(-car.getDirection());
                }
                else if (y > maxY) {
                    car.setYPos(maxY);
                    car.setDirection(-car.getDirection());
                }

                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }

    void startEngine() {
        for (Car car : cars
        ) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : cars
        ) {
            car.stopEngine();
        }
    }
}
