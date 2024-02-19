import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    private CarController cc;
    private HashMap<Class, BufferedImage> vehicleImages = new HashMap<>();

    public DrawPanel(CarController cc, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
        this.cc = cc;
        try {
            loadImages();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadImages() throws IOException {
        vehicleImages.put(Volvo240.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
        vehicleImages.put(Saab95.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
        vehicleImages.put(Scania.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        // Antag att VolvoBrand.jpg är en allmän bild som inte associeras med en specifik fordonstyp
        vehicleImages.put(Object.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle vehicle : cc.vehicles) {
            int x = (int) Math.round(vehicle.getXPos());
            int y = (int) Math.round(vehicle.getYPos());
            BufferedImage image = vehicleImages.get(vehicle.getClass());
            if (image != null) {
                g.drawImage(image, x, y, null);
            }
        }
        // Exempel på hur man ritar en allmän bild om inget specifikt fordon matchades
        int xPos = (int) Math.round(cc.volvoServiceShop.getXPos());
        int yPos = (int) Math.round(cc.volvoServiceShop.getYPos());
        g.drawImage(vehicleImages.get(Object.class), xPos, yPos, null);
    }
}