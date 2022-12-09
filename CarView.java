

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CarView extends JFrame {
    private static final int X = 800;
    private static final int Y = 800;
    DrawPanel drawPanel = new DrawPanel(800, 560);
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    public CarView(String framename) {
        this.initComponents(framename);
    }

    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(800, 800));
        this.setLayout(new FlowLayout(0, 0, 0));
        this.add(this.drawPanel);
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        this.gasSpinner = new JSpinner(spinnerModel);
        this.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                CarView.this.gasAmount = (Integer)((JSpinner)e.getSource()).getValue();
            }
        });
        this.gasPanel.setLayout(new BorderLayout());
        this.gasPanel.add(this.gasLabel, "First");
        this.gasPanel.add(this.gasSpinner, "Last");
        this.add(this.gasPanel);
        this.controlPanel.setLayout(new GridLayout(2, 4));
        this.controlPanel.add(this.gasButton, 0);
        this.controlPanel.add(this.turboOnButton, 1);
        this.controlPanel.add(this.liftBedButton, 2);
        this.controlPanel.add(this.brakeButton, 3);
        this.controlPanel.add(this.turboOffButton, 4);
        this.controlPanel.add(this.lowerBedButton, 5);
        this.controlPanel.setPreferredSize(new Dimension(404, 200));
        this.add(this.controlPanel);
        this.controlPanel.setBackground(Color.CYAN);
        this.startButton.setBackground(Color.blue);
        this.startButton.setForeground(Color.green);
        this.startButton.setPreferredSize(new Dimension(145, 200));
        this.add(this.startButton);
        this.stopButton.setBackground(Color.red);
        this.stopButton.setForeground(Color.black);
        this.stopButton.setPreferredSize(new Dimension(145, 200));
        this.add(this.stopButton);
        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }
}
