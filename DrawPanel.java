import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import src.Scania;
import src.Volvo240;
import src.Saab95;
import src.Vehichle;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    ArrayList<VehichleWrapper> vehicles = new ArrayList<>();

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    void addVehicles() {
        vehicles.add(new VehichleWrapper(new Volvo240(), new Point(0, 0)));
        vehicles.add(new VehichleWrapper(new Saab95(), new Point(0, 100)));
        vehicles.add(new VehichleWrapper(new Scania(), new Point(0, 200)));
    }

    // TODO: Make this general for all cars
    void moveit(Vehichle vehichle, int x, int y){
        for (VehichleWrapper vehicle : vehicles) {
            if (vehicle.getVehicle() == vehichle) {
                vehicle.setPosition(x, y);
            }
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        addVehicles();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (VehichleWrapper vehicle : vehicles) {
            g.drawImage(vehicle.getImage(), vehicle.getX(), vehicle.getY(), null);
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
