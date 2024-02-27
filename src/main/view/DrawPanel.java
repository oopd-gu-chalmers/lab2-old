package src.main.view;

import src.main.controller.CarController;
import src.main.model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements ActionListener {

    private VehicleModel model;
    private HashMap<Class, BufferedImage> vehicleImages = new HashMap<>();

    public DrawPanel(VehicleModel model) {
        this.model = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(model.getWidth(), model.getHeight()-240));
        this.setBackground(Color.cyan);
        try {
            loadImages();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){this.repaint();}



    private void loadImages() throws IOException {
        vehicleImages.put(Volvo240.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
        vehicleImages.put(Saab95.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
        vehicleImages.put(Scania.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        vehicleImages.put(Object.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle vehicle : cc.getVehicleList()) {   // Gå igenom en lista av drawables
            int x = (int) Math.round(vehicle.getXPos());
            int y = (int) Math.round(vehicle.getYPos());
            BufferedImage image = vehicleImages.get(vehicle.getClass());
            if (image != null) {
                g.drawImage(image, x, y, null);
            }
        }
        int xPos = (int) Math.round(cc.volvoServiceShop.getXPos());
        int yPos = (int) Math.round(cc.volvoServiceShop.getYPos());
        g.drawImage(vehicleImages.get(Object.class), xPos, yPos, null);
    }
}