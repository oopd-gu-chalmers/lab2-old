import java.awt.*;

/** Represents a base model of a truck that a truck is based on.
 */
public abstract class Truck extends Vehicle {
    private Ramp ramp = new Ramp();

    public Truck(double x, double y, int nrDoors, double enginePower, double currentSpeed,
                 Color color, String modelName, int directionAngle) {

        super(x, y, nrDoors, enginePower, currentSpeed, color, modelName, directionAngle);
    }
}
