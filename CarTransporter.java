import java.awt.*;

import java.util.List;
import java.util.ArrayList;

public class CarTransporter extends Truck {
    private final int maxSize; // the max number of cars that the CarTransporter can hold.
    private final List<Car> cars;
    private final Ramp ramp = new Ramp();

    public CarTransporter(int nrDoors, double enginePower, double currentSpeed,
                          Color color, String modelName, int maxSize) {
        super(0,0, nrDoors, enginePower, currentSpeed, color, modelName,0);
        this.maxSize = Math.min(maxSize, 6);
        cars = new ArrayList<>();
        stopEngine();
    }

    /**
     * Sets the carTransporter's ramp up
     */

    public void raiseRamp(){
        ramp.raiseRamp();
    }

    /**
     * Sets the carTransporter's ramp down
     */
    public void lowerRamp(){
        if(isStationary()) {
            ramp.lowerRamp();
        }
    }

    /**
     * Checks if the carTransporter's ramp is up
     *
     * @return a boolean representing if ramp is up or down
     */
    public boolean isRampRaised(){
        return ramp.isRampRaised();
    }



    /**
     * Gets a list of cars that are currently on the CarTransporter.
     *
     * @return List cars that contains the car's that are currently on the CarTransporter.
     */
    public List<Car> getCars() {
        return cars;
    }

    /** Checks if car is close enough to CarTransporter for pickup.
     *
     * @param c the car that you want to load on to the CarTransporter.
     * @return boolean true if the car is close enough, otherwise false.
     */
    public boolean isCarCloseEnough(Car c) {
        return (getX() - 5 < c.getX() && c.getX() < getX() + 5) 
            && (getY() - 5 < c.getY() && c.getY() < getY() + 5);
    }

    /** Determines whether the truck is in motion;
     * @return true if getCurrentSpeed() is equal to 0,
     * otherwise returns false
     */
    public boolean isStationary() {
        return getCurrentSpeed() == 0;
    }

    public boolean isCarStationary(Car car) {
        return car.getCurrentSpeed() == 0;
    }

    /** Adds a car to the carTransporter's ramp
     * Cars can only be loaded if: the carTransporter is stationary
     * ramp is down, and the cars are reasonably close to car
     *
     * @param car a Car
     */
    public void loadCar(Car car) {
        if (canLoadCar(car) && isCarStationary(car)) {
            cars.add(car);
        }
    }

    /**
     * Unloads a car from the carTransporter's ramp
     * Cars can only be unloaded if: the carTransporter is stationary
     * ramp is down, and the cars are reasonably close to CarTransporter.
     *
     */
    public void unloadCar() {
        if (canUnloadCar()) {
            cars.get(lastLoadedIndex()).setX(getX() + 5);
            cars.remove(lastLoadedIndex());
        }
    }

    /** Returns the index of the last car added into the list cars.
     *
     * @return index of the car last loaded
     */
    int lastLoadedIndex() {
        return cars.size() - 1;
    }


    /**
     * Checks if CarTransporter can load the car.
     *
     * @param car the car that wants to be loaded
     * @return a boolean that's true if car can be loaded, otherwise false
     */
    public boolean canLoadCar(Car car) {
        if(maxSize > cars.size()) {
            return canLoadOrUnloadCar() && isCarCloseEnough(car);
        }
        return false;
    }
  
 //CarTransporter can't load itself since it doesn't extend car(it extends vehicle).

    /**
     * Checks if CarTransporter can unload a car.
     * CarTransporter has to contain at least one car, if a car is supposed to be unloaded
     * @return boolean that is true if cartransporter can unload car, otherwise false.
     */
    public boolean canUnloadCar() {
        return !cars.isEmpty() && canLoadOrUnloadCar();

    }

    /**
     * Checks if a car can interact with CarTransporter, ie if CarTransporter is stationary, car is close enough and ramp is down
     *
     * @return boolean representing true if car can be loaded/removed, otherwise false
     */
    public boolean canLoadOrUnloadCar() {
        if (isStationary()) {
            return !isRampRaised();
        }
        return false;
    }

    /**
     * Returns a speedFactor based on carTranpsporter's enginePower.
     *
     * @return the speedFactor
     */
    @Override
    public double speedFactor() { return getEnginePower() * 0.01; }

    /**
     * Helper method for testing.
     * Converts the list cars into a string which contains the names of the cars.
     * @return the names of the cars as a string.
     */
    public String carsToString() {
        if(cars.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for(int i = 0; i<cars.size() -1; i++) {
            sb.append(cars.get(i).getModelName());
            sb.append(", ");
        }
        sb.append(cars.get(cars.size() -1).getModelName());
        sb.append("]");
        return sb.toString();
    }

    /** Moves the CarTransporter forwards in a certain direction.
     * Changes x and y values for CarTransporter, as well as for the cars that are loaded onboard.
     */
    @Override
    public void move() {
        super.move();
        for(Car car: cars) {
            car.setX(getX());
            car.setY(getY());
        }
    }

    /**
     * Gas the truck.
     *
     * If the platform is raised then the truck will not gas.
     * Takes a number between 1 and 0.
     * @param amount how hard you press the gas
     */
    @Override
    public void gas(double amount) {
        if(isRampRaised()) {
            super.gas(amount);
        }
    }

    /**
     * Starts the engine of the truck.
     * If the platform is raised, then the engine will not start.
     */

    @Override
    public void startEngine() {
        if(isRampRaised()) {
            super.startEngine();
        }
    }
}
