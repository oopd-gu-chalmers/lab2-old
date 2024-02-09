import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


public class Saab95Test{
    private Saab95 TestSaab;
    @BeforeEach
    public void setupTestsaab(){
        TestSaab = new Saab95();
    }
    @Test
    public void TurboOntest() {
        assertFalse(TestSaab.statusTurboOn());
    }
    @Test
    public void colorofsaabtest() {
        assertEquals(Color.red, TestSaab.getColor());
    }
    @Test
    public void saabenginepowertest() {
        assertEquals(125, TestSaab.getEnginePower(), 0);
    }
    @Test
    public void setTurboOntest() {
        TestSaab.setTurboOn();
        assertTrue(TestSaab.statusTurboOn());
    }
    @Test
    public void setTurboOfftest() {
        TestSaab.setTurboOff();
        assertFalse(TestSaab.statusTurboOn());
    }
    @Test
    public void saabspeedfactorwithTurbotest() {
        TestSaab.setTurboOn();
        assertEquals(1.625,TestSaab.speedFactor());
    }
    @Test
    public void saabspeedfactorwithouTurbotest() {
        TestSaab.setTurboOff();
        assertEquals(1.25,TestSaab.speedFactor());
    }
}

