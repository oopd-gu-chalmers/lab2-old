package src.main;

import src.main.controller.CarController;
import src.main.model.VehicleModel;
import src.main.model.*;
import src.main.view.DrawPanel;

import java.awt.*;

public class CreateGame {

    public static void main(String[] args) {
        // Create model
        VehicleModel model = createModel();

        // Create drawPanel
        DrawPanel drawPanel = new DrawPanel(model);   // definiera fönstrets storlek i modellen

        // Create ui
        UserInterface ui = createUserinterface(drawPanel, model);  // lägg in panelen här

        // Create controller
        CarController cc = new CarController(model, ui);


        model.addListener(drawPanel);

        // Add listeners
        ui.addGasButtonListener(cc.createGasActionListener());
        ui.addBrakeButtonListener(cc.createBrakeActionListener());
        ui.addStartButtonListener(cc.createStartActionListener());
        ui.addStopButtonListener(cc.createStopActionListener());
        ui.addTurboOnButtonListener(cc.createTurboOnActionListener());
        ui.addTurboOffButtonListener(cc.createTurboOffActionListener());
        ui.addLiftBedButtonListener(cc.createLiftBedActionListener());
        ui.addLowerBedButtonListener(cc.createLowerBedActionListener());
        ui.addGasSpinnerListener(cc.createGasSpinnerChangeListener());

        // Get serviceshop and set position
        ServiceShop<Volvo240> volvoServiceShop = model.getVolvoServiceShop();
        volvoServiceShop.setXPos(0);
        volvoServiceShop.setYPos(300);

        // Start the timer
        cc.timer.start();


    }

    public static VehicleModel createModel(){
        VehicleModel model = new VehicleModel();

        Vehicle volvo = VehicleFactory.createVolvo240(4, 100, Color.BLACK, "ILoveVolvo");
        model.addVehicle(volvo);

        Vehicle saab = VehicleFactory.createSaab(4,50,Color.RED,"ILoveSaab",true);
        saab.setXPos(0);
        saab.setYPos(100);
        model.addVehicle(saab);

        Vehicle scania = VehicleFactory.createScania(2, 100, Color.BLUE, "ILoveScania");
        scania.setXPos(0);
        scania.setYPos(200);
        model.addVehicle(scania);

        return model;
    }

    private static UserInterface createUserinterface(DrawPanel panel, VehicleModel model) {
        UserInterface ui = new UserInterface("CarSim 1.0", panel, model.getWidth(), model.getHeight());
        return ui;
        // nåt mer
    }

}
