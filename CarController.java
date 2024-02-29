import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    World world;
    CarView frame;
    int gasAmount = 0;

    public CarController(World w, CarView frame){
        this.world = w;
        this.frame = frame;
        initializeListeners();
    }
    private void initializeListeners() {
    frame.gasSpinner.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
            gasAmount = (int) ((JSpinner)e.getSource()).getValue();
        }
    });

    frame.gasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            world.gas(gasAmount);
        }
    });

    frame.brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            world.brake(gasAmount);
        }
    });

    frame.startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            world.startEngines();;
        }
    });

    frame.stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            world.stopEngines();
        }
    });

    frame.turboOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            world.saabTurboOff();
        }
    });

    frame.turboOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            world.saabTurboOn();
        }
    });

    frame.liftBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            world.PlatformUp();
        }
    });

    frame.lowerBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            world.PlatformDown();
        }
    });

    //Ny för sista delen av labben
    frame.addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            world.addRandomCar();
        }  
    });

    frame.removeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            world.removeCar();
        }  
    });
    }
}
