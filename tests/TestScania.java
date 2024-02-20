import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;


public class TestScania {
    private Scania scania;

    @BeforeEach
    public void setUp() {
        scania = new Scania(2, 4, Color.RED, "Scania1");
    }

    @Test
    public void testInitialValues() {
        assertEquals(0, scania.getBedAngle());
    }

    @Test
    public void testBedAngleLimits() {
        assertThrows(IllegalArgumentException.class, () -> scania.setBedAngle(-10));
        assertThrows(IllegalArgumentException.class, () -> scania.setBedAngle(80));
    }

    @Test
    public void testRaiseWhileMoving() {
        scania.startEngine();
        scania.gas(0.5);
        assertThrows(IllegalStateException.class, () -> scania.raise());
    }

    @Test
    public void testMoveWhenBedRaised() {
        scania.raise();
        assertThrows(IllegalStateException.class, () -> scania.gas(0.5));
    }
}

