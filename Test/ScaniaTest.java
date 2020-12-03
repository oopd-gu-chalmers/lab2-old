import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

class ScaniaTest {

    Scania scania = new Scania(2,350,0, Color.green,"Scania" );

    @Test
    public void isRampRaised() {
        assertFalse(scania.isRampRaised());
    }

    @Test
    public void raisePlatform() {
        scania.raisePlatformAngle(60);
        assertTrue(scania.isRampRaised());
    }

    @Test
    public void lowerPlatform() {
        scania.lowerPlatformAngle(60);
        assertFalse(scania.isRampRaised());
    }
    /*
    @Test
    public void getPlatformAngle() {
        assertEquals(0, scania.getPlatformAngle());
    }

    @Test
    public void setPlatformAngle() {
        scania.setPlatformAngle(20);
        assertEquals(20, scania.getPlatformAngle());
    }

    @Test
    public void raisePlatformAngle() {
        scania.raiseRamp(80);
        assertEquals(70, scania.getPlatformAngle());
    }

    @Test
    public void lowerPlatformAngle() {
        scania.setPlatformAngle(45);
        scania.lowerRamp(50);
        assertEquals(0, scania.getPlatformAngle());
    }

    @Test
    public void canRaisePlatformAngle() {
        assertTrue(scania.isStationary());
    }

    @Test
   public void canNotRaisePlatformAngle() {
        scania.gas(1);
        assertFalse(scania.isStationary());
    }

    @Test
   public void isPlatformRaisedFalse() {
        scania.setPlatformAngle(0);
        assertFalse(scania.isRampRaised());
    }

    @Test
    public void isPlatformRaisedTrue() {
        scania.setPlatformAngle(45);
        assertTrue(scania.isRampRaised());
    }

    @Test
    public void speedFactor() {
        assertEquals(3.5, scania.speedFactor(), 0.001);
    }

    @Test
    public void shouldGas() {
        Scania scania = new Scania(2,350,0, Color.green,"Scania" );
        scania.gas(1);
        assertEquals(3.5, scania.getCurrentSpeed());
    }

    @Test
    public void shouldNotGas() {
        Scania scania = new Scania(2,350,0, Color.green,"Scania" );
        scania.raiseRamp(45);
        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed());
    }

*/

}