import java.awt.*;

/** Represents a Volvo240 car.
 * It has the following attributes:
 * a final static double representing the trimFactor
 * The class also have following methods:
 * speedFactor()
 */
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;


    public Volvo240(double x, double y, int nrDoors, double enginePower, double currentSpeed,
                    Color color, String modelName, int directionAngle){
        super(x,y, nrDoors, enginePower, currentSpeed, color, modelName,directionAngle);
        stopEngine();
    }


    public Volvo240(int nrDoors, double enginePower, double currentSpeed,
                    Color color, String modelName){
        super(0,0, nrDoors, enginePower, currentSpeed, color, modelName,0);
        stopEngine();
    }

    /** Returns a speedFactor based on Volvo's enginePower and trimFactor.
     * @return a speedFactor
     * */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
