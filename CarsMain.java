import java.awt.*;

import static java.lang.System.out;
import static  java.lang.Math.*;


public class CarsMain {
    public static void main(String[] args){
        CarTransporter cartransporter = new CarTransporter(3, 350, 0, Color.red, "Cartransporter",
                2);
        Volvo240 volvo1 = new Volvo240(4, 100, 0, Color.black, "Volvo1");
        cartransporter.lowerRamp();
        cartransporter.loadCar(volvo1);
        cartransporter.raiseRamp();
        cartransporter.gas(1);
        cartransporter.move();
        out.println(cartransporter.getY());
        out.println(volvo1.getY());




    }
}
