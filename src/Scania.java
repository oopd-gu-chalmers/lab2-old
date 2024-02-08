package src;

import java.awt.*;

public class Scania extends Truck{
    private static final int maxAngle = 70;
    private ScaniaPlatform carPlatform;
    public Scania(){
        super(2, Color.BLACK, 500, "Scania");
        carPlatform = new ScaniaPlatform(maxAngle);
    }
    public double getRampAngle(){
        return carPlatform.getPlatformAngle();
    }
    public void raisePlatform(){
        if (getCurrentSpeed()>0){
            throw new IllegalStateException("Can't raise platform while moving");
        } else {
            carPlatform.rampUp();
        }
    }
    public void lowerPlatform(){
        if (getCurrentSpeed()>0){
            throw new IllegalStateException("Can't lower platform while moving");
        } else {
            carPlatform.rampDown();
        }
    }
    public boolean getPlatformStatus(){
        return carPlatform.isRampDown();
    }
}
