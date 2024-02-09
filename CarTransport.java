import java.awt.*;
import java.util.*;

public abstract class CarTransport extends Truck implements Loadable<Car>{ 
    
    //Car transport only accepts cars, as defined by Loadable<Car> and Loader<Car>.

    private int maxLoadNum;
    private boolean rampDown;
    private Deque<Car> loadedVehicles = new LinkedList<Car>();
    private Loader<Car> loader = new Loader<Car>(this);
    private double[] sizeLimits = {0, 0};

    public CarTransport(int nrDoors, Color color, double enginePower, String modelName, int maxLoadNum, double lengthLimit, double widthLimit) {
        super(nrDoors, color, enginePower, modelName);
        setSizeLimits(lengthLimit, widthLimit);
        rampDown = true;
        this.maxLoadNum = maxLoadNum;
    }
    
    public Deque<Car> getCurrentLoad() {
        return loadedVehicles;
    }

    @Override
    public boolean driveableTilt() {
        return rampDown;
    }

    public double[] getSizeLimits() {
        return sizeLimits;
    }

    protected void setSizeLimits(double length, double width) {
        sizeLimits[0] = length;
        sizeLimits[1] = width;
    }

    public int getMaxLoad() {
        return maxLoadNum;
    }

    @Override
    public void raiseTilt() {
        if (getCurrentSpeed() == 0){
            rampDown = false;
        }
    }
    @Override
    public void lowerTilt() {
        if (getCurrentSpeed() == 0){
            rampDown = true;
        }
    }

    public void load(Car car) {
        if (rampDown && car.getSize()[0] < sizeLimits[0] && car.getSize()[1] < sizeLimits[1]) {
            loader.load(car);
        }
    }

    public Car unload() {
        if (rampDown) {
            return loader.unloadLast();
        } 
        return null;
    }

    @Override 
    public void move(){ 
        super.move();
        for (Car x : loadedVehicles) { //Move all cars to the position of the car transport, and change their heading to match the car transport.
            x.setDirection(getDirection());
            x.setCurrentPos(getCurrentPos()[0], getCurrentPos()[1]);
        }
    }
}
