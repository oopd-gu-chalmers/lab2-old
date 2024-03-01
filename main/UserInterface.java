package main;

import main.view.DrawPanel;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class UserInterface extends JFrame {

    DrawPanel drawPanel;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    public JSpinner gasSpinner = new JSpinner();

    JLabel gasLabel = new JLabel("Amount of gas");

    public JButton gasButton = new JButton("Gas");
    public JButton brakeButton = new JButton("Brake");
    public JButton turboOnButton = new JButton("Saab Turbo on");
    public JButton turboOffButton = new JButton("Saab Turbo off");
    public JButton liftBedButton = new JButton("Lift Bed");
    public JButton lowerBedButton = new JButton("Lower Lift Bed");

    public JButton startButton = new JButton("Start all cars");
    public JButton stopButton = new JButton("Stop all cars");
    public JButton addCarButton = new JButton("Add car");

    public JButton removeCarButton = new JButton("Remove car");

    public JButton turnLeftButton = new JButton("Turn left");

    public JButton turnRightButton = new JButton("Turn right");

    private int frameWidth;
    private int frameHeight;

    // Constructor
    public UserInterface(String framename, DrawPanel panel, int width, int height) {
        this.drawPanel = panel; // Kanske kan skapas i carcontroller
        this.frameWidth = width;
        this.frameHeight = height;
        initComponents(framename);

    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(frameWidth, frameHeight));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        // Create spinner
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);


        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOffButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addCarButton, 3);
        controlPanel.add(turnLeftButton, 4);
        controlPanel.add(brakeButton, 5);
        controlPanel.add(turboOnButton, 6);
        controlPanel.add(lowerBedButton, 7);
        controlPanel.add(removeCarButton, 8);
        controlPanel.add(turnRightButton, 9);

        controlPanel.setPreferredSize(new Dimension((frameWidth / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(frameWidth / 5 - 15, 200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(frameWidth / 5 - 15, 200));
        this.add(stopButton);


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void addGasButtonListener(ActionListener al) {gasButton.addActionListener(al);}

    public void addBrakeButtonListener(ActionListener al) {brakeButton.addActionListener(al);}

    public void addStartButtonListener(ActionListener al) {
        startButton.addActionListener(al);
    }

    public void addStopButtonListener(ActionListener al) {
        stopButton.addActionListener(al);
    }

    public void addTurboOnButtonListener(ActionListener al) {
        turboOnButton.addActionListener(al);
    }

    public void addTurboOffButtonListener(ActionListener al) {
        turboOffButton.addActionListener(al);
    }

    public void addLiftBedButtonListener(ActionListener al) {
        liftBedButton.addActionListener(al);
    }

    public void addLowerBedButtonListener(ActionListener al) {
        lowerBedButton.addActionListener(al);
    }
    public void addAddCarButtonListener(ActionListener al) {
        addCarButton.addActionListener(al);
    }
    public void addGasSpinnerListener(ChangeListener cl) {
        gasSpinner.addChangeListener(cl);
    }

    public void addRemoveCarButtonListener(ActionListener al) {
        removeCarButton.addActionListener(al);
    }

    public void addTurnLeftButtonListener(ActionListener al) {
        turnLeftButton.addActionListener(al);
    }

    public void addTurnRightButtonListener(ActionListener al) {
        turnRightButton.addActionListener(al);
    }
}
