import java.awt.*;

abstract class Truck extends Vehicle implements TiltablePosterior{

    public Truck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }

    public abstract boolean driveableTilt();

    public abstract void raiseTilt();

    public abstract void lowerTilt();

    public void startEngine(){
        if (driveableTilt()) {
            currentSpeed = 0.1;
        }
    }
    @Override
    public void gas(double amount){
        if (driveableTilt()) {;
            super.gas(amount);
        } else {
            throw new IllegalStateException("Platform needs to be in driving mode");
        }
    }
    
}
