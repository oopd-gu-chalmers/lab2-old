import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import src.Vehichle;

public class VehichleWrapper {
    private Vehichle vehicle;
    private Point position; 
    private BufferedImage image;

    public VehichleWrapper(Vehichle vehicle, Point position) {
        this.vehicle = vehicle;
        this.position = position;
        try {
			this.image = javax.imageio.ImageIO.read(new java.io.File("src/" + vehicle.getModelName() + ".jpg"));
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
