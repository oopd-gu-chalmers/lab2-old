

import java.util.ArrayList;

public class CarWorkshop<T extends Car> {
    public ArrayList<T> carInWorkshop;
    private int maximumCapacity;

    public CarWorkshop(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.carInWorkshop = new ArrayList();
    }

    public void loadCar(T carIntoWorkshop) {
        if (this.carInWorkshop.size() <= this.maximumCapacity) {
            this.carInWorkshop.add(carIntoWorkshop);
        }

    }

    public T unloadCar() {
        return this.carInWorkshop.size() > 0 ? (T)this.carInWorkshop.remove(0) : null;
    }
}
