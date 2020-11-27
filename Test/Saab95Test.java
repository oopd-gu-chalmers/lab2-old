import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Saab95Test {
    Saab95 saab95 = new Saab95(4,125,0, Color.black, "Saab95");

    @Test
    public void setTurboOn() {
        saab95.setTurboOn();
        assertTrue(saab95.isTurboOn());
    }

    @Test
    public void setTurboOff() {
        saab95.setTurboOff();
        assertFalse(saab95.isTurboOn());
    }

    @Test
    public void speedFactorTurboOff() {
        saab95.setTurboOff();
        assertEquals(1.25, saab95.speedFactor(), 0.001);
    }

    @Test
    public void speedFactorTurboOn() {
        saab95.setTurboOn();
        assertEquals(1.625, saab95.speedFactor(), 0.001);
    }

}