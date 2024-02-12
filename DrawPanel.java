import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;
    BufferedImage volvoWorkshopImage;
    // To keep track of a single car's position
    //Point carPoint = new Point();

    ArrayList<Vehicle> cars = new ArrayList<>();
    Workshop<?> workshop;

    // TODO: Make this general for all cars
    void moveit(ArrayList<Vehicle> cars){
        this.cars = cars;
    }

    void loadWorkshop(Workshop<?> workshops) { //Load workshops should handle multiple workshops?
        this.workshop = workshops;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
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
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) { // NOT GOOD!
        super.paintComponent(g);
        for(Vehicle car : cars) {
            int x = (int) Math.round(car.getCurrentPos()[0]);
            int y = (int) Math.round(car.getCurrentPos()[1]);
            if (car.getmodelName() == "Saab95") {
                g.drawImage(saabImage, x, y, null); // see javadoc for more info on the parameters
            } else if (car.getmodelName() == "Volvo240") {
                g.drawImage(volvoImage, x, y, null);
            } else if (car.getmodelName() == "Scania") {
                g.drawImage(scaniaImage, x, y, null);
            }
        }
        int x = (int) Math.round(workshop.getCurrentPos()[0]);
        int y = (int) Math.round(workshop.getCurrentPos()[1]);
        g.drawImage(volvoWorkshopImage, x, y, null);
    }
}

