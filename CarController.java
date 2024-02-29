
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

 //yeet

public class CarController {
    // member fields:
    World world;

    public CarController(World w){
        this.world=w;
    }
  
    void gas(int amount) {
        world.gas(amount);
    }

    void brake(int amount) {
        world.brake(amount);
    }

    void startEngines() {
        world.startEngines();
    }

    void stopEngines() {
        world.stopEngines();
    }

    void saabTurboOn() {
        world.saabTurboOn();
    }

    void saabTurboOff() {
        world.saabTurboOff();
    }

    void PlatformDown() {
        world.PlatformDown();
    }

    void PlatformUp() {
        world.PlatformUp();
    }
    void addRandomCar(){
        world.addRandomCar();
    }
    void removeCar(){
        world.removeCar();
    }
}
