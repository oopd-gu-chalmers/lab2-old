import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    private CarController cc;
    private HashMap<String, BufferedImage> vehicleImages = new HashMap<>();

    public DrawPanel(CarController cc, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
        this.cc = cc;
        try {
            loadVehicleImages();
        } catch (IOException e) {
            e.printStackTrace();
            // Hantera fel, t.ex. visa ett felmeddelande
        }
    }

    private void loadVehicleImages() throws IOException {
        // Antag att vi har en mapp "pics" i resurskatalogen och bilder namngivna efter fordonstyper
        vehicleImages.put("Volvo240", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
        vehicleImages.put("Saab95", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
        vehicleImages.put("Scania", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        // Lägg till fler bilder efter behov
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle vehicle : cc.vehicles) {
            if (vehicle instanceof Volvo240) {
                BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))
                int x = (int) Math.round(vehicle.getXPos());
                int y = (int) Math.round(vehicle.getYPos());
                g.drawImage(image, x, y, null);
            } else if (vehicle instanceof Saab95) {
                BufferedImage image = vehicleImages.get(vehicle.getClass().getSimpleName());
                int x = (int) Math.round(vehicle.getXPos());
                int y = (int) Math.round(vehicle.getYPos());
                g.drawImage(image, x, y, null);
            } else if (vehicle instanceof Scania) {

            }
            BufferedImage image = vehicleImages.get(vehicle.getClass().getSimpleName());
            int x = (int) Math.round(vehicle.getXPos());
            int y = (int) Math.round(vehicle.getYPos());
            g.drawImage(image, x, y, null);
            }
        }
    }