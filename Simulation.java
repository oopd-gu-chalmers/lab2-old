
public class Simulation{

    public static void main(String[] args) {
        World world = new World();
        CarController controller = new CarController(world);
        controller.AddVolvo();
        controller.AddSaab();
        controller.AddScania();
        CarView frame= new CarView("yeehaw", controller);
        world.AddObserver(frame.drawPanel);
    }
}

