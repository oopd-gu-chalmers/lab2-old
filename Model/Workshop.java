package Model;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

import View.DrawPanel;

public class Workshop<A extends Vehicle> implements DrawableWithPosition, Loadable<A>{ 
    
    //Workshop handles a generic type which is passed to both Loadable and Loader. The type determines,
    //what type of vehicles it can handle. For example only Saab95.
    private BufferedImage image;
    private int maxVehicles;  
    private Loader<A> loader = new Loader<A>(this);
    
    private double x_pos; // Coordinate Position x
    private double y_pos; // Coordinate Position y

    public Workshop(double x, double y, int maxVehicles) {
        setCurrentPos(x, y);
        this.maxVehicles = maxVehicles;
        setImage("pics/VolvoBrand.jpg");
    };

    public Deque<A> getCurrentLoad() {
        return loader.load;
    }
    
    public int getMaxLoad() {
        return maxVehicles;
    }
    
    public void load(A vehicle) {
        loader.load(vehicle);
    }

    public A unload() {
        return loader.unloadFirst();
    }
    public double[] getCurrentPos() { // Added for test of move().
        double[] pos = {x_pos, y_pos};
        return pos;
    }
    public void setCurrentPos(double x, double y) { // Added for test of move().
        x_pos = x;
        y_pos = y;
    }
    public BufferedImage getImage(){
        return image;
    }
    public void setImage(String imagePath){
        try {
            this.image = ImageIO.read(DrawPanel.class.getResourceAsStream(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


