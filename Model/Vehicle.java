package Model;
import java.awt.*;
import java.lang.Math;
import javax.imageio.ImageIO;

import View.CarView;

import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Vehicle implements DrawableWithPosition, Moveable{

    private BufferedImage image;//default is Volvo 240
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double direction; // anglee in degrees, 0 is to the right.
    private double[] dimensions = {0, 0};
    private final int turndegrees = 30; // Constant number of degrees for a turn.
    private double x_pos; // Coordinate Position x
    private double y_pos; // Coordinate Position y

    public Vehicle(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        setEnginePower(enginePower);
        this.modelName = modelName;
        setCurrentPos(0, 0);
        this.direction = 0;
        stopEngine();
        setImage("/pics/Volvo240.jpg");
    }
    
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }

    public double getDirection() { // Added for test of turn()
        return direction;
    }
    protected void setDirection(double angle) {
        direction = angle;
    }
    public void setEnginePower(double amount){
        if (amount >= 0){
	        enginePower = amount;
        } else {
            throw new IllegalArgumentException("Enginepower needs to be >= 0");
        }
    }
    public void setColor(Color clr){
	    color = clr;
    }
    public double[] getSize() {
        return dimensions;
    }
    protected void setSize(double length, double width) {
        dimensions[0] = length;
        dimensions[1] = width;
    }
    public String getmodelName(){
        return modelName;
    }
    
    abstract public void startEngine();

    public void stopEngine(){
	    currentSpeed = 0;
    }

    public boolean isEngineOn() {
        return getCurrentSpeed() > 0;
    }

    abstract protected double speedFactor();

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    
    public void gas(double amount){
        if (isEngineOn()) {
            if(amount >= 0 && amount <= 1){
                incrementSpeed(amount);
            } else {
                throw new IllegalArgumentException("invalid amount");
            }
        } else {
            throw new IllegalStateException("Engine needs to be turned on!");
        }
    }

    public void brake(double amount){
        if(amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("invalid amount");
        }
    }

    public void move(){ 
        setCurrentPos(getCurrentPos()[0] + Math.cos(direction * Math.PI / 180) * getCurrentSpeed(),
        getCurrentPos()[1] + Math.sin(direction * Math.PI / 180) * getCurrentSpeed());
    }

    public void turnLeft(){
        direction = direction + turndegrees;
    }

    public void turnRight(){
        direction = direction - turndegrees;
    }
    public double[] getCurrentPos() { // Added for test of move().
    double[] pos = {x_pos, y_pos};
    return pos;
    }
    public void setCurrentPos(double x, double y) { // Added for test of move().
        x_pos = x;
        y_pos = y;
    }
    public BufferedImage getImage(){
        return image;
    }
    public void setImage(String imagePath){
        try {
            this.image = ImageIO.read(CarView.class.getResourceAsStream(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

