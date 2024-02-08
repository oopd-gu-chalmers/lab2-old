import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVolvo {

    private Volvo240 testVolvo;

    @BeforeEach
    public void init() {
        testVolvo = new Volvo240(4, 2, Color.BLUE, "testSaab");
    }

    @Test
    public void testspeedFactor() {
        assertEquals(testVolvo.speedFactor(), testVolvo.getEnginePower() * 0.01 * 1.25);
    }

    @Test
    public void testincrementSpeed() {
        testVolvo.startEngine();
        double expectedSpeed = Math.min(testVolvo.getCurrentSpeed() + testVolvo.speedFactor() * 0.8, testVolvo.getEnginePower());
        testVolvo.incrementSpeed(0.8);
        assertEquals(testVolvo.getCurrentSpeed(), expectedSpeed);
    }

    @Test
    public void testdecrementSpeed() {
        testVolvo.startEngine();
        double expectedSpeed = Math.max(testVolvo.getCurrentSpeed() - testVolvo.speedFactor() * 0.3, 0);
        testVolvo.decrementSpeed(0.3);
        assertEquals(testVolvo.getCurrentSpeed(), expectedSpeed);
    }

    @Test
    public void testGas() {
        testVolvo.startEngine();
        double expectedSpeed = Math.min(testVolvo.getCurrentSpeed() + testVolvo.speedFactor() * 0.3, testVolvo.getEnginePower());
        testVolvo.gas(0.3);
        assertEquals(testVolvo.getCurrentSpeed(), expectedSpeed);
    }

    @Test
    public void testBrake() {
        testVolvo.startEngine();
        double expectedSpeed = Math.max(testVolvo.getCurrentSpeed() - testVolvo.speedFactor() * 0.7, 0);
        testVolvo.brake(0.7);
        assertEquals(testVolvo.getCurrentSpeed(), expectedSpeed);
    }
}
