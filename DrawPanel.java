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
    private ArrayList<BufferedImage> images = new ArrayList<>();
    private BufferedImage image;

    public DrawPanel(CarController cc, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
        this.cc = cc;
        try {
            loadVehicleImages();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadVehicleImages() throws IOException {
        images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
        images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
        images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle vehicle : cc.vehiclesInMotion) {  //eventuellt gå igenom alla
            int x = (int) Math.round(vehicle.getXPos());
            int y = (int) Math.round(vehicle.getYPos());
            if (vehicle instanceof Volvo240) {
                image = images.get(0);
            } else if (vehicle instanceof Saab95) {
                image = images.get(1);
            } else if (vehicle instanceof Scania) {
                image = images.get(2);
            }
            g.drawImage(image, x, y, null);
        int xPos = (int) Math.round(cc.volvoServiceShop.getXPos());
        int yPos = (int) Math.round(cc.volvoServiceShop.getYPos());
        g.drawImage(images.get(3), xPos, yPos, null);


        }
        }
    }