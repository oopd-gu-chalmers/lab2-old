import java.awt.*;
import java.util.Stack;

public class CarTransportBed{

    private boolean isRaised;

    private final Stack<Car> storage = new Stack<>();

    protected void raise() {
        this.isRaised = true;
    }

    protected void lower() {
        this.isRaised = false;
    }

    protected boolean getIsRaised(){return this.isRaised;}

    protected Stack<Car> getStorage() {
        return storage;
}}