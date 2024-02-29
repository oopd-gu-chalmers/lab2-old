
public class Simulation{
    private static final int X=800;
    private static final int Y=800;


    public static void main(String[] args) {
        World world = new World(X,Y,6);
        CarView frame= new CarView("yeehaw",X,Y);
        CarController controller = new CarController(world, frame);
        world.AddObserver(frame.drawPanel);
    }
}

