
public class Simulation{
    private static final int X=800;
    private static final int Y=800;


    public static void main(String[] args) {
        World world = new World(X,Y);
        CarController controller = new CarController(world);
        controller.AddVolvo();
        controller.AddSaab();
        controller.AddScania();
        CarView frame= new CarView("yeehaw", controller,X,Y);
        world.AddObserver(frame.drawPanel);
    }
}

