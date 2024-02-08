import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.Vehichle;

public class VehichleWrapper {
    private Vehichle vehicle;
    private Point position; 
    private BufferedImage image;

    public VehichleWrapper(Vehichle vehicle) {
        this.vehicle = vehicle;
        this.position = new Point();
        this.position.x = (int) vehicle.getX();
        this.position.y = (int) vehicle.getY();
        try {
			this.image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+vehicle.getModelName()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
            
    }
    public int getX() {
        return position.x;
    }
    public Vehichle getVehicle() {
        return vehicle;
    }
    public int getY() {
        return position.y;
    }
    public BufferedImage getImage() {
        return image;
    }
    public void setPosition(int x, int y) {
        this.position.setLocation(x,y);
    }

}
