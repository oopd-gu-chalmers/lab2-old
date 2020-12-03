import org.junit.Test;
import org.junit.Before;
import java.awt.*;
import static java.lang.System.out;

import static org.junit.Assert.*;

public class CarTest {

    Volvo240 volvo240 = new Volvo240(4, 100,0, Color.black, "Volvo240");

    @Test
    public void getNrDoors() {
        assertEquals(4, volvo240.getNrDoors());
    }

    @Test
    public void setNrDoors() {
        volvo240.setNrDoors(2);
        assertEquals(2, volvo240.getNrDoors());
    }

    @Test
    public void getEnginePower() {
        assertEquals(100, volvo240.getEnginePower(), 0.001);
    }

    @Test
    public void setEnginePower() {
        volvo240.setEnginePower(200);
        assertEquals(200, volvo240.getEnginePower(), 0.001);
    }

    @Test
    public void getCurrentSpeed() {
        assertEquals(0, volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    public void getColor() {
        assertEquals(Color.black, volvo240.getColor());
    }

    @Test
    public void setColor() {
        volvo240.setColor(Color.blue);
        assertEquals(Color.blue, volvo240.getColor());
    }

    @Test
    public void getModelName() {
        assertEquals("Volvo240", volvo240.getModelName());
    }

    @Test
    public void setModelName() {
        volvo240.setModelName("Volvo740");
        assertEquals("Volvo740", volvo240.getModelName());
    }

    @Test
    public void startEngine() {
        volvo240.startEngine();
        assertEquals(0.1, volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    public void stopEngine() {
        volvo240.startEngine();
        volvo240.stopEngine();
        assertEquals(0,volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    public void moveForX() {
        volvo240.startEngine();
        volvo240.gas(1);
        volvo240.move();
        assertEquals(0, volvo240.getX(), 0.001);
    }

    @Test
    public void moveForY() {
        volvo240.startEngine();
        volvo240.gas(1);
        volvo240.move();
        assertEquals(-1.35, volvo240.getY(), 0.001);
    }

    @Test
    public void turnLeftForX() {
        volvo240.startEngine();
        volvo240.turnLeft(90);
        volvo240.gas(1);
        volvo240.move();
        out.print(volvo240.getDirectionAngle());
        assertEquals(-1.35, volvo240.getX(), 0.001);
    }

    @Test
    public void turnLeftForY() {
        volvo240.startEngine();
        volvo240.turnLeft(90);
        volvo240.gas(1);
        volvo240.move();
        assertEquals(0, volvo240.getY(), 0.001);
    }


    @Test
    public void testToString() {

        assertEquals("( x: " + volvo240.getX() + ", y: "  + volvo240.getY() + ", currentSpeed: " + volvo240.getCurrentSpeed() + ", " + ")", volvo240.toString());
    }

    @Test
    public void gasCorrect() {
        volvo240.gas(1);
        assertEquals(1.25, volvo240.getCurrentSpeed(), 0.001);
    }



    /*@Test
    public void gasWrong() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setCurrentSpeed(90);
        volvo240.gas(-1);
        assertEquals(90, volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    public void brakeCorrect() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setCurrentSpeed(90);
        volvo240.brake(1);
        assertEquals(88.75, volvo240.getCurrentSpeed(), 0.001);
    }

    @Test
    public void brakeWrong(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.setCurrentSpeed(90);
        volvo240.brake(-1);
        assertEquals(90, volvo240.getCurrentSpeed(), 0.001);
    }*/
}