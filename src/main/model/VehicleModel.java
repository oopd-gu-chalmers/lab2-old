package src.main.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleModel {
    private final VehicleList vehicleList;

    private final ServiceShop volvoServiceShop = new ServiceShop(10);
    private static final int width = 800;
    private static final int height = 800;

    public VehicleModel(){
        this.vehicleList = new VehicleList();
    }

    public void addVehicle(Vehicle v){
        vehicleList.addCar(v);
        notifyListeners();

    }

    public void updateVehicles(){
        for (Vehicle v : vehicleList.getVehicles()) {
                v.move();
                checkCollisionWithVolvoServiceShop(v);
                notifyListeners();
    }}

    private void checkCollisionWithVolvoServiceShop(Vehicle vehicle) {
        if (vehicle.getCurrentSpeed() != 0){
            if (Math.abs(vehicle.getXPos() - volvoServiceShop.getXPos()) < 5 && Math.abs(vehicle.getYPos() - volvoServiceShop.getYPos()) < 5){
                if (vehicle instanceof Volvo240) {
                    Volvo240 volvo = (Volvo240) vehicle;
                    volvoServiceShop.load(volvo);
                    volvo.stopEngine();
                }
            }
        }}

    public ArrayList<Vehicle> getVehicles(){return vehicleList.getVehicles();
    }

    public ServiceShop getVolvoServiceShop(){return volvoServiceShop;}

    // Listener methods
    private final ArrayList<ActionListener> listeners = new ArrayList<>();

    public void addListener(ActionListener listener) {
        listeners.add(listener);
    }

    protected void notifyListeners() {
        ActionEvent event = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "modelUpdated");
        for (ActionListener listener : listeners) {
            listener.actionPerformed(event);
        }}

    public int getWidth() {
        return width;
        }

    public int getHeight() {
        return height;
        }
    }

