import java.awt.*;

public abstract class Vehicle implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xPos; // x-position of the car
    private double yPos; // y-position of the car
    private double direction; // direction of the car in radians

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.xPos = 0;
        this.yPos = 0;
        this.direction = Math.PI/2;
        stopEngine();
    }


    protected int getNrDoors(){
        return nrDoors;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

    protected double getXPos() {
        return xPos;
    }

    protected double getYPos() {
        return yPos;
    }

    protected double getDirection() {
        return direction;
    }

    protected void setXPos(double x) {
        xPos = x;
    }

    protected void setYPos(double y) {
        yPos = y;
    }

    protected void setDirection(double dir) {
        direction = (dir % (2*Math.PI) + 2*Math.PI)%(2*Math.PI);
    }

    public void move() {
        xPos += currentSpeed * Math.cos(direction);
        yPos += currentSpeed * Math.sin(direction);
    }

    public void turnLeft() {
        direction = (direction + Math.PI /2) % (2*Math.PI);
    }

    public void turnRight() {
        direction = (direction - Math.PI/2 + 2*Math.PI) % (2*Math.PI);
    }

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    };

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    };

    protected void gas(double amount) {
        if (amount >= 0 && amount <=1){
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Argument must be between 0 and 1");
        }
    }

    protected void brake(double amount){
        if (amount >= 0 && amount <=1){
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Argument must be between 0 and 1");
        }
    }
}
