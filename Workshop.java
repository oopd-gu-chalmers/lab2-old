import java.util.*;

public class Workshop<A extends Vehicle> extends ObjectWithPosition implements Loadable<A>{ 
    
    //Workshop handles a generic type which is passed to both Loadable and Loader. The type determines,
    //what type of vehicles it can handle. For example only Saab95.

    private int maxVehicles;
    private Deque<A> loadedVehicles = new LinkedList<A>();     
    private Loader<A> loader = new Loader<A>(this);

    public Workshop(double x, double y, int maxVehicles) {
        setCurrentPos(x, y);
        this.maxVehicles = maxVehicles;
    };

    public Deque<A> getCurrentLoad() {
        return loadedVehicles;
    }
    
    public int getMaxLoad() {
        return maxVehicles;
    }
    
    public void load(A vehicle) {
        loader.load(vehicle);
    }

    public A unload() {
        return loader.unloadFirst();
    }
}


