package main.view;

import main.Drawable;
import main.model.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements ModelUpdateListener {

    private HashMap<Class, BufferedImage> vehicleImages = new HashMap<>();

    private VehicleModel model;

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

    private void loadImages() throws IOException {
        for (Drawable drawable : model.getDrawables() ) {
            vehicleImages.put(drawable.getClass(), ImageIO.read(new File(("main/view/pics/" + drawable.getClass().getSimpleName() + ".jpg"))));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable drawable : model.getDrawables() ) {
            int x = (int) Math.round(drawable.getXPos());
            int y = (int) Math.round(drawable.getYPos());
            BufferedImage image = vehicleImages.get(drawable.getClass());
            if (image != null) {
                g.drawImage(image, x, y, null);
            }
        }
    }

    @Override
    public void actOnModelUpdate() {this.repaint();}
}