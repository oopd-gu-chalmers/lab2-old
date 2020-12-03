import java.awt.*;

/**
 * Represents a Saab95 car.
 * It has the following attributes:
 * A boolean representing that Saab95's turbo is On or Off.
 * The class also have following methods:
 * setTurboOn(), setTurboOff(), isTurboOn() and speedFactor()
 */
public class Saab95 extends Car {
private Turbo turbo = new Turbo();

    public Saab95(double x, double y,int nrDoors, double enginePower, double currentSpeed,
                  Color color, String modelName, int directionAngle){
        super(x,y, nrDoors, enginePower, currentSpeed, color, modelName,directionAngle);
        setTurboOff();
        stopEngine();
    }

    public Saab95(int nrDoors, double enginePower, double currentSpeed,
                  Color color, String modelName){
        super(0,0, nrDoors, enginePower, currentSpeed, color, modelName,0);
        setTurboOff();
        stopEngine();
    }

    /**
     * Sets turboOn true.
     */
    public void setTurboOn(){
	    turbo.setTurboOn();
    }

    /**
     *  Sets turboOn false.
     */
    public void setTurboOff(){
	    turbo.setTurboOff();
    }

    /**
     * @return a boolean representing turboOn is true or false.
     */
    public boolean isTurboOn() {
        return turbo.isTurboOn();
    }

    /**
     * @return a double representing speedFactor
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(isTurboOn()) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
