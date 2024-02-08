import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

public class TestVehicle {
    private Vehicle testVehicle;

    @BeforeEach
    public void init(){
        testVehicle = new Volvo240(4, 2, Color.BLUE,"testVolvo" );
    }

    @Test
    public void testStartEngine(){
        testVehicle.startEngine();
        assertEquals(testVehicle.getCurrentSpeed(), 0.1);
    }

    @Test
    public void testStopEngine() {
        testVehicle.startEngine();
        testVehicle.stopEngine();
        assertEquals(testVehicle.getCurrentSpeed(), 0.0);
    }

    @Test
    public void testMove() {
        testVehicle.startEngine();
        testVehicle.move();
        assertEquals(testVehicle.getXPos() + testVehicle.getYPos() , 0 + 0.1);
    }

    @Test
    public void testTurnLeft() {
        double firstDirection = testVehicle.getDirection();
        testVehicle.turnLeft();
        assertEquals(testVehicle.getDirection(),firstDirection+(Math.PI/2) );
    }

    @Test
    public void testTurnRight() {
        double firstDirection = testVehicle.getDirection();
        testVehicle.turnRight();
        assertEquals(testVehicle.getDirection(),firstDirection-(Math.PI/2) );
    }

    @Test
    public void testGetNrDoors() {
        assertEquals(testVehicle.getNrDoors(), 4);
    }


    @Test
    public void testgetEnginePower() {
        assertEquals(testVehicle.getEnginePower(), 2);
    }

    @Test
    public void testgetCurrentSpeed() {
        testVehicle.startEngine();
        assertEquals(testVehicle.getCurrentSpeed(), 0.1);
    }

    @Test
    public void testgetColor() {
        assertEquals(testVehicle.getColor(), Color.BLUE);
    }

    @Test
    public void testgetXpos() {
        assertEquals(testVehicle.getXPos(), 0);
    }

    @Test
    public void testgetYPos() {
        assertEquals(testVehicle.getYPos(), 0);
    }

    @Test
    public void testgetDirection() {
        assertEquals(testVehicle.getDirection(), Math.PI/2);
    }

    @Test
    public void testsetDirection() {
        testVehicle.setDirection(Math.PI);
        assertEquals(testVehicle.getDirection(), Math.PI);
    }

    @Test
    public void testsetXpos() {
        testVehicle.setXPos(0);
        assertEquals(testVehicle.getXPos(), 0);
    }
    @Test
    public void testsetYpos() {
        testVehicle.setYPos(0);
        assertEquals(testVehicle.getYPos(), 0);
    }

    @Test
    public void testsetColor() {
        testVehicle.setColor(Color.BLUE);
        assertEquals(testVehicle.getColor(), Color.BLUE);
    }

    @Test
    public void testCurrentSpeedWithinBounds() {
        testVehicle.startEngine();
        assertTrue(testVehicle.getCurrentSpeed() >= 0 && testVehicle.getCurrentSpeed() <= testVehicle.getEnginePower());
    }

    @Test
    public void testGasWithinBounds() {
        testVehicle.startEngine();
        assertThrows(IllegalArgumentException.class, () -> testVehicle.brake(1.5));
    }
    @Test
    public void testBrakelowerSpeed() {
        testVehicle.startEngine();
        testVehicle.gas(1);
        double firstSpeed = testVehicle.getCurrentSpeed();
        testVehicle.brake(0.5);
        assertTrue(firstSpeed > testVehicle.getCurrentSpeed());
    }
    @Test
    public void testGasincrementSpeed() {
        testVehicle.startEngine();
        double firstSpeed = testVehicle.getCurrentSpeed();
        testVehicle.gas(0.5);
        assertTrue(firstSpeed < testVehicle.getCurrentSpeed());
    }
    }
