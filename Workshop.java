import java.util.*;

public class Workshop<A extends Vehicle> implements DrawableWithPosition, Loadable<A>{ 
    
    //Workshop handles a generic type which is passed to both Loadable and Loader. The type determines,
    //what type of vehicles it can handle. For example only Saab95.
    private String imagePath = "pics/VolvoBrand.jpg";
    private int maxVehicles;
    private Deque<A> loadedVehicles = new LinkedList<A>();     
    private Loader<A> loader = new Loader<A>(this);
    
    private double x_pos; // Coordinate Position x
    private double y_pos; // Coordinate Position y

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
    public double[] getCurrentPos() { // Added for test of move().
        double[] pos = {x_pos, y_pos};
        return pos;
    }
    public void setCurrentPos(double x, double y) { // Added for test of move().
        x_pos = x;
        y_pos = y;
    }
    public String getImage(){
        return imagePath;
    }
    public void setImage(String image){
        imagePath = image;
    }
}


