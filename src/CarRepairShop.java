package src;

import java.awt.geom.Point2D;
import java.util.Stack;

public class CarRepairShop<T extends Car> implements Loadable<T> {
    private CarLoader loadedCars;
    private Point2D shopLocation;

    public CarRepairShop(int capacity, double x, double y) {
        shopLocation = new Point2D.Double(x, y);
        loadedCars = new CarLoader(capacity);
    }
    public double shopX() {
        return shopLocation.getX();
    }
    public double shopY() {
        return shopLocation.getY();
    }
    public void unloadCar() {
        loadedCars.unloadCar();
    }
    public void loadCar(T car) {
        loadedCars.loadCar(car, shopX(), shopY());
    }
    public boolean loadable(T car){
        return loadedCars.carProximity(car, shopX(), shopY());
    }
    public Stack<Car> getLoadedCars() {
        return loadedCars.getLoadedCars();
    }
}

