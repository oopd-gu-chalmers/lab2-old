import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class Simulation implements ActionListener{

    private static final int delay = 50;
    private Timer timer = new Timer(delay, this);
    CarController controller = new CarController();
    CarView frame= new CarView("yeehaw", controller);

    public static void main(String[] args) {
        Simulation sim = new Simulation();
        sim.controller.cars.add(new Volvo240());
        sim.controller.cars.add(new Saab95());
        sim.controller.cars.get(1).setCurrentPos(0, 100);
        sim.controller.cars.add(new Scania());
        sim.controller.cars.get(2).setCurrentPos(0, 200);
        ArrayList<DrawableWithPosition> objects = new ArrayList<DrawableWithPosition>();
        objects.addAll(sim.controller.cars);
        objects.add(sim.controller.workshop);
        sim.frame.drawPanel.loadObjects(objects);
        sim.timer.start();
    }


    public void actionPerformed(ActionEvent e) {
        this.controller.checkForCollisionWithWorkshop();
        this.controller.checkForCollisionWithBorder(frame.getPreferredSize().getWidth());
        this.controller.moveAllCars();
        // repaint() calls the paintComponent method of the panel
        this.frame.drawPanel.repaint();
    }
}

