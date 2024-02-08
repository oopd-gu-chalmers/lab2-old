package src;

import java.util.Stack;

public class CarLoader{

    private Stack<Car> loadedCars;
    private int capacity;

    public CarLoader(int capacity) {
        loadedCars = new Stack<Car>();
        this.capacity=capacity;
    }

    public void loadCar(Car car, double x, double y){
        if (!carProximity(car, x, y)){
            throw new IllegalStateException("Car not close enough to load");
        } else if (car.getCarSizeCategory()>1){
            throw new IllegalStateException("Car too big to load");
        }
        if (loadedCars.size() < capacity){
            if (loadedCars.contains(car)){
                return;
            }
            loadedCars.add(car);
            car.setLocation(x, y);
            car.stopEngine();
            car.setLoaded(true);
        } else {
            throw new IllegalStateException("is full");
        }
    }

    public Stack<Car> getLoadedCars() {
        return loadedCars;
    }

    public boolean carProximity(Car car, double x, double y){
        double xCar = car.getX();
        double yCar = car.getY();
        double dist = Math.sqrt(Math.pow(xCar-x,2)+Math.pow(yCar-y,2));
        return dist < 3;
    }
    public void unloadCar() {
            if (!loadedCars.empty()){
                Car car = loadedCars.pop();
                car.setLocation(car.getX(), car.getY()-1);
                car.setLoaded(false);
            } else {
                throw new IllegalArgumentException("No car to unload");
            }
    }
}
