import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    ArrayList<DrawableWithPosition> objects = new ArrayList<>();

    void loadObjects(ArrayList<DrawableWithPosition> objects) { //Load workshops should handle multiple workshops?
        this.objects = objects;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    @Override
    protected void paintComponent(Graphics g) { //Good 
        super.paintComponent(g);
        for(DrawableWithPosition object : objects) {
            int x = (int) Math.round(object.getCurrentPos()[0]);
            int y = (int) Math.round(object.getCurrentPos()[1]);
            try{
            g.drawImage(ImageIO.read(DrawPanel.class.getResourceAsStream(object.getImage())), x, y, null); // see javadoc for more info on the parameters   
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        }
    }
}

