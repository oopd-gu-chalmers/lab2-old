import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class ServiceShop<T extends Car> implements Loadable<T> {
    private final List<T> storage = new ArrayList<>();  // Composition
    private final int maxCapacity;  // Maximalt antal bilar som verkstaden kan ta emot

    private double xPos;
    private double yPos;

    public ServiceShop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void load(T car) {
        if (storage.size() < maxCapacity) {
            storage.add(car);
        } else {
            throw new IllegalStateException("Verkstaden är full.");
        }
    }

    public T unload() {
        if (!storage.isEmpty()) {
            return storage.removeFirst();
        } else {
            throw new NoSuchElementException("Bilen finns inte i verkstaden.");
        }
    }

    protected List<T> getStorage() {
        return storage;
    }

    protected double getXPos() {
        return xPos;
    }

    protected double getYPos() {
        return yPos;
    }

    protected void setXPos(double x) {
        xPos = x;
    }

    protected void setYPos(double y) {
        yPos = y;
    }
}

//ServiceShop<Saab95> shop = new ServiceShop<>();
