package main;

import main.controller.CarController;
import main.model.VehicleModel;
import main.model.*;

import java.awt.*;

public class CreateGame {

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.volvoServiceShop.setXPos(0);
        cc.volvoServiceShop.setYPos(300);

        Volvo240 volvo = new Volvo240(4, 100, Color.BLACK, "ILoveVolvo");
        cc.vehicles.add(volvo);

        Saab95 saab = new Saab95(4,50,Color.RED,"ILoveSaab",true);
        cc.vehicles.add(saab);
        saab.setXPos(0);
        saab.setYPos(100);

        Scania scania = new Scania(2, 100, Color.BLUE, "ILoveScania");
        cc.vehicles.add(scania);
        scania.setXPos(0);
        scania.setYPos(200);

        // Start a new view and send a reference of self
        cc.frame = new UserInterface("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();

        VehicleModel components = createModel();
    }

    public static VehicleModel createModel(){
        VehicleModel components = new VehicleModel();

        components.addVehicle(VehicleFactory.createVolvo240(4, 100, Color.BLACK, "ILoveVolvo"));
        components.addVehicle(VehicleFactory.createSaab(4,50,Color.RED,"ILoveSaab",true));
        components.addVehicle(VehicleFactory.createScania(2, 100, Color.BLUE, "ILoveScania"));

        return components;
    }


}
