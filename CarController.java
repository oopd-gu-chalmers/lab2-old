
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

 //yeet

public class CarController {
    // member fields:
    World world;
    //methods:
        // public static void main(String[] args) {
        // // Instance of this class
        // CarController cc = new CarController();
        // // Start a new view and send a reference of self
        // cc.frame = new CarView("CarSim 1.0", cc);
        // cc.frame.drawPanel.loadWorkshop(cc.workshop);
        // // Start the timer
        // cc.timer.start();}
            


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    public CarController(World w){
        this.world=w;
    }
  
    // Calls the gas method for each car once
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
    void AddVolvo(){
        world.AddVolvo();
    }
    void AddSaab(){
        world.AddSaab();
    }
    void AddScania(){
        world.AddScania();
    }
    void AddVolvoFM9(){
        world.AddVolvoFM9();
    }
}
