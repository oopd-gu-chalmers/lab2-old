
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;

/** Represents a Car Repair Shop.
 *
 * A Car Repair Shop loads a number of cars, up to a maximum number that can vary between different workshops.
 * Some workshops should only be able to accommodate a certain type of car;
 * others can receive any car.
 * Trying to receive the "wrong" sort of car in a workshop should give a static (compile time) error.
 * When retrieving a car from the workshop, we must be able to get as specific static type information as possible.
 * Example: A car retrieved from a branded workshop that only handles the Volvo 240 should have static type Volvo240.
 * @param <C> a class that extends the Car, either the Volvo240 or Saab95 class
 */
public class CarRepairShop<C extends Car> {
    private List<C> cars;
    private int maxSize;

    public CarRepairShop(int maxSize){
        this.maxSize = maxSize;
        this.cars = new ArrayList<>();
    }


    /** Adds a car to the Car Repair Shop.
     * You can only add new cars to the repair shop if the maxSize isn't reached yet,
     * ie you can't add car if the shop is full.
     *
     * @param item a Car
     */
    public void loadCar(C item){
        if(maxSize > cars.size()) {
            cars.add(item);
        }
    }

    /** Removes a car from the Car Repair Shop
     *
     * @param item a car
     */
    public void removeCar(C item){
        cars.remove(item);
    }

    /**
     * Gets the list of cars currently in Car repair shop.
     * @return the list of cars currently in car repair shop.
     */
    public List<C> getCars() {
        return cars;
    }



    public static void main(String[] args) {
        Saab95 saab95 = new Saab95(4, 100,0, Color.black, "Saab95");
        Volvo240 volvo240 = new Volvo240(4, 100,0, Color.black, "Volvo240");
        CarRepairShop<Saab95> saab95RepairShop = new CarRepairShop<>(2);

        saab95RepairShop.loadCar(saab95);
        //saab95RepairShop.loadCar(volvo240);

        CarRepairShop<Car> anyCarRepairShop = new CarRepairShop<>(2);
        anyCarRepairShop.loadCar(saab95);
        anyCarRepairShop.loadCar(volvo240);


    }
}
