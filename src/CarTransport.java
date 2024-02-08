package src;

import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck implements Loadable<Car>{
    private CarLoader loadedCars;
    private CarPlatform carPlatform;

    CarTransport(){
        super(2, Color.BLACK, 500, "CarTransport");
        loadedCars = new CarLoader(3);
        carPlatform = new CarPlatform();
    }
    
    @Override
    public void move() {
        if (getPlatformStatus()){
            super.move();
            for (Car car : loadedCars.getLoadedCars()){
                car.setLocation(getX(), getY());
            }
        } else {
            throw new IllegalStateException("Cant move while truck bed is raised");
        }
    }
    public void raisePlatform(){
        if (getCurrentSpeed()>0){
            throw new IllegalStateException("Cant raise platform while moving");
        } else {
            carPlatform.rampUp();
        }
    }
    public void lowerPlatform(){
        if (getCurrentSpeed()>0){
            throw new IllegalStateException("Cant lower platform while moving");
        } else {
            carPlatform.rampDown();
        }
    }
    public void loadCar(Car car){
        if (getPlatformStatus()){
            loadedCars.loadCar(car, getX(), getY());
        } else {
            throw new IllegalStateException("Cant load car while truck bed is raised");
        }
    }
    public void unloadCar(){
        if (getPlatformStatus()){
            loadedCars.unloadCar();
        } else {
            throw new IllegalStateException("Cant unload car while truck bed is raised");
        }
    }
    public Stack<Car> getLoadedCars() {
        return loadedCars.getLoadedCars();
    }

    public boolean getPlatformStatus(){
        return carPlatform.isRampDown();
    }
}
