//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
        return this.carInWorkshop.size() > 0 ? (Car)this.carInWorkshop.remove(0) : null;
    }
}
