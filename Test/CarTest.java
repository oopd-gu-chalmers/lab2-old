import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Saab95 TestSaab;
    @BeforeEach
    public void setupTestsaab(){
        TestSaab = new Saab95();
        TestSaab.startEngine();
    }
    @Test
    public void modelnametest() {
        assertEquals("Saab95", TestSaab.getmodelName());
    }
    @Test
    public void Nrofdoorsinmodeltest() {
        assertEquals(2, TestSaab.getNrDoors());
    }
    @Test
    public void colorswitchtest() {
        TestSaab.setColor(Color.blue);
        assertEquals(Color.blue, TestSaab.getColor());
    }
    @Test
    public void gasOutOfBoundsHigher() {
        assertThrows(IllegalArgumentException.class, () -> TestSaab.gas(2), "Gas above 1 is allowed");
    }
    @Test
    public void gasOutOfBoundsLower() {
        assertThrows(IllegalArgumentException.class, () -> TestSaab.gas(-1), "Gas below zero is allowed");
    }
    @Test
    public void gasAsExpected() {
        double beforegas = TestSaab.getCurrentSpeed();
        TestSaab.gas(1);
        assertEquals(beforegas + TestSaab.getEnginePower()*0.01*1, TestSaab.getCurrentSpeed());
    }
    @Test
    public void brakeOutOfBoundsHigher() {
        assertThrows(IllegalArgumentException.class, () -> TestSaab.brake(2), "Brake above 1 is allowed");
    }
    @Test
    public void brakeOutOfBoundsLower() {
        assertThrows(IllegalArgumentException.class, () -> TestSaab.brake(-1), "Brake below zero is allowed");
    }
    @Test
    public void brakeAsExpected() {
        TestSaab.gas(1);
        double beforebrake = TestSaab.getCurrentSpeed();
        TestSaab.brake(1);
        assertEquals(beforebrake - TestSaab.getEnginePower()*0.01*1, TestSaab.getCurrentSpeed());
    }
    @Test
    public void saabEnginePowerTest() {
        assertThrows(IllegalArgumentException.class, () -> TestSaab.setEnginePower(-10), "Expected enginePower to not be negative but it is");
    }
    @Test
    public void moveAsExpected() {
        double[] startpos = TestSaab.getCurrentPos();
        TestSaab.startEngine();
        TestSaab.gas(1);
        TestSaab.move();
        double[] endpos = TestSaab.getCurrentPos();
        assertEquals(startpos[0] + TestSaab.getCurrentSpeed(), endpos[0], "Car in unexpected position on x axis");
    }
    @Test
    public void turnAsExpected() {
        TestSaab.turnLeft();
        TestSaab.turnRight();
        TestSaab.turnLeft();
        assertEquals(30, TestSaab.getDirection());
    }
}
