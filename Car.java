import java.awt.*;

abstract public class Car extends Vehicle{
    public Car(int nrDoors, Color color, double enginePower, String modelName){
        super(nrDoors, color, enginePower, modelName);
    }
    public void startEngine(){
	    currentSpeed = 0.1;
    }
}
