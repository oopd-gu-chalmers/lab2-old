import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Simulation{
    CarView frame;
    CarController controller;
    private static final int delay = 50;
    Timer timer = new Timer(delay,new TimerListener());


    public static void main(String[] args) {
        CarController controller = new CarController();
        CarView frame= new CarView("yeehaw", controller);
        controller.cars.add(new Volvo240());
        controller.cars.add(new Saab95());
        controller.cars.get(1).setCurrentPos(0, 100);
        controller.cars.add(new Scania());
        controller.cars.get(2).setCurrentPos(0, 200);
    }

    public class TimerListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            controller.checkForCollisionWithWorkshop();
            controller.checkForCollisionWithBorder();
            controller.moveAllCars();
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }
}

