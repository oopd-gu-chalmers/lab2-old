import java.awt.Point;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.Vehichle;

public class VehichleWrapper extends Wrapper{
    private Vehichle vehicle;

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
    public void moveit(){
        position.x = (int) vehicle.getX();
        position.y = (int) vehicle.getY();
    }
    public Vehichle getVehicle() {
        return vehicle;
    }
}
