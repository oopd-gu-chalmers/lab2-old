package main.model;
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

    public boolean getIsRaised(){return this.isRaised;}

    public Stack<Car> getStorage() {
        return storage;
}}