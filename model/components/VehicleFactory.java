package model.components;

import java.awt.*;

public class VehicleFactory {

    public static Vehicle createSaab(int nrDoors, double enginePower, Color color, String modelName, boolean turboOn){
        return new Saab95(nrDoors, enginePower, color, modelName, turboOn);
    }

    public static Vehicle createVolvo240(int nrDoors, double enginePower, Color color, String modelName){
        return new Volvo240(nrDoors, enginePower, color, modelName);
    }

    public static Vehicle createScania(int nrDoors, double enginePower, Color color, String modelName){
        return new Scania(nrDoors, enginePower, color, modelName);
    }
}
