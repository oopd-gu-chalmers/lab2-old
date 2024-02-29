package View;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import Model.DrawableWithPosition;
import Model.WorldObserver;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements WorldObserver{

    ArrayList<? extends DrawableWithPosition> objects = new ArrayList<>();

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
            g.drawImage(object.getImage(), x, y, null); // see javadoc for more info on the parameters   
        }
    }

    public void update(ArrayList<? extends DrawableWithPosition> newobjects){
        this.objects=newobjects;
        repaint();
    }
}

