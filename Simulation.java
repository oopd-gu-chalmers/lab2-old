
public class Simulation{

    public static void main(String[] args) {
        World world = new World();
        CarController controller = new CarController(world);
        controller.AddVolvo();
        controller.AddSaab();
        controller.AddScania();
        CarView frame= new CarView("yeehaw", controller);
        world.AddObserver(frame.drawPanel);


        //sim.controller.cars.get(1).setCurrentPos(0, 100);     Detta behöver vi lösa

        //sim.controller.cars.get(2).setCurrentPos(0, 200);
    }
}

