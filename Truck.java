import java.awt.*;

public abstract class Truck extends Vehicle implements HasBed {

    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


    //@Override
    public void raise() {
        if (this.getCurrentSpeed() == 0)
            raiseBed();
        else
            throw new IllegalStateException("Can't raise bed while moving.");
    }

    //@Override
    public void lower() {
        if (this.getCurrentSpeed() == 0) {
            lowerBed();}
        else
            throw new IllegalStateException("Can't lower bed while moving.");
    }

    protected abstract void raiseBed();

    protected abstract void lowerBed();


}



