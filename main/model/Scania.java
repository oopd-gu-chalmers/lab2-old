package main.model;

import java.awt.*;

public class Scania extends Truck {
    private final ScaniaBed scaniaBed = new ScaniaBed();

    public Scania(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

//    @Override
//    public void move(){ //vad är skillanden mot gas? varför behövs båda? vi får väl move från vehicle?
//        //den här körs hela tiden när programmet startas... Antagligen därför man inte kna raisa bed direkt pga datorn tror att scania redan rör sig
//        //System.out.println("Moving truck with bed angle: " + scaniaBed.getAngle() + ", speed: " + getCurrentSpeed());
//        if (scaniaBed.getAngle() == 0)
//            super.move();
//        else
//            throw new IllegalStateException("Can't move when bed is raised");
//    }
//    //en fråga: ska alla bilar inte kunna köra om bed är raised? nej väl?

    public int getBedAngle() {
        return scaniaBed.getAngle();
    }

    public void setBedAngle(int angle) {
        if (this.getCurrentSpeed() == 0)
            scaniaBed.setAngle(angle);

    }

    @Override
    public void gas(double amount){
        if (scaniaBed.getAngle() > 0)
            throw new IllegalStateException("Can't gas when bed is raised.");
        else
            super.gas(amount);
    };

    @Override
    protected void raiseBed() {
        scaniaBed.raise();
    }


    @Override
    protected void lowerBed() {
        scaniaBed.lower();
    }
}

