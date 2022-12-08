//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;

public class Vehicle implements Movable {
    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;
    private double xPosition = 0.0D;
    private double yPosition = 0.0D;
    private int direction = 1;

    public Vehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double xPosition, double yPosition, int direction) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;
    }

    public int getNrDoors() {
        return this.nrDoors;
    }

    public double getEnginePower() {
        return this.enginePower;
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public Color getColor() {
        return this.color;
    }

    public double getxPosition() {
        return this.xPosition;
    }

    public double getyPosition() {
        return this.yPosition;
    }

    public int getDirection() {
        return this.direction;
    }

    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    public void setColor(Color clr) {
        this.color = clr;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public void startEngine() {
        this.currentSpeed = 0.1D;
    }

    public void stopEngine() {
        this.currentSpeed = 0.0D;
    }

    public void move() {
        if (this.direction == 1) {
            this.yPosition += this.currentSpeed;
        } else if (this.direction == 2) {
            this.xPosition += this.currentSpeed;
        } else if (this.direction == 3) {
            this.yPosition -= this.currentSpeed;
        } else if (this.direction == 4) {
            this.xPosition -= this.currentSpeed;
        }

    }

    public int turnLeft() {
        --this.direction;
        if (this.direction == 0) {
            this.direction = 4;
        }

        return this.direction;
    }

    public int turnRight() {
        ++this.direction;
        if (this.direction == 5) {
            this.direction = 1;
        }

        return this.direction;
    }

    public double speedFactor() {
        return this.getEnginePower() * 0.01D;
    }

    public void gas(double amount) {
        if (amount >= 0.0D && amount <= 1.0D) {
            this.incrementSpeed(amount);
        }

    }

    public void brake(double amount) {
        if (amount >= 0.0D && amount <= 1.0D) {
            this.decrementSpeed(amount);
        }

    }

    public void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(this.getCurrentSpeed() + this.speedFactor() * amount, this.getEnginePower()));
    }

    public void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(this.getCurrentSpeed() - this.speedFactor() * amount, 0.0D));
    }
}
