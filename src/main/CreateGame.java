package src.main;

import src.main.controller.CarController;
import src.main.model.VehicleModel;
import src.main.model.*;

import java.awt.*;

public class CreateGame {

    public static void main(String[] args) {
        // Create model
        VehicleModel model = createModel();

        // Create controller
        CarController cc = new CarController(model);

        // Create view
        UserInterface view = new UserInterface("CarSim 1.0", cc);

        // Set the view in the controller
        cc.setView(view);


        cc.volvoServiceShop.setXPos(0);
        cc.volvoServiceShop.setYPos(300);

        /*Volvo240 volvo = new Volvo240(4, 100, Color.BLACK, "ILoveVolvo");
        cc.getVehicleList().add(volvo);

        Saab95 saab = new Saab95(4,50,Color.RED,"ILoveSaab",true);
        cc.getVehicleList().add(saab);
        saab.setXPos(0);
        saab.setYPos(100);

        Scania scania = new Scania(2, 100, Color.BLUE, "ILoveScania");
        cc.getVehicleList().add(scania);
        scania.setXPos(0);
        scania.setYPos(200);*/



        // Start the timer
        cc.timer.start();


    }

    public static VehicleModel createModel(){
        VehicleModel model = new VehicleModel();

        model.addVehicle(VehicleFactory.createVolvo240(4, 100, Color.BLACK, "ILoveVolvo"));
        model.addVehicle(VehicleFactory.createSaab(4,50,Color.RED,"ILoveSaab",true));
        model.addVehicle(VehicleFactory.createScania(2, 100, Color.BLUE, "ILoveScania"));

        return model;
    }


}
