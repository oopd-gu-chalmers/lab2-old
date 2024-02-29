import main.model.Car;
import main.model.CarTransport;
import main.model.Volvo240;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

public class TestCarTransport {
    private CarTransport carTransport;
    private Car volvoCar;

    @BeforeEach
    public void setUp() {
        carTransport = new CarTransport(2, 5, Color.BLUE, "CarTransport1");
        volvoCar = new Volvo240(2, 4, Color.RED, "main.model.Car");
    }
    @Test
    public void testRaiseLowerWhileStill() {
        carTransport.stopEngine();
        carTransport.lower();
        assertFalse(carTransport.getBedIsRaised());

        carTransport.raise();
        assertTrue(carTransport.getBedIsRaised());
    }

    @Test
    public void testRaiseLowerWhileMoving() {
        carTransport.startEngine();
        carTransport.gas(0.5);
        assertThrows(IllegalStateException.class, () -> carTransport.lower());
    }

    @Test
    public void testLoadCar() {
        carTransport.stopEngine();
        carTransport.lower();
        carTransport.load(volvoCar);
        assertEquals(carTransport.getTransportBed().getStorage().pop(), volvoCar);
    }

    @Test
    public void testUnloadCar() {
        carTransport.stopEngine();
        carTransport.lower();
        carTransport.load(volvoCar);
        carTransport.unload();
        assertTrue(carTransport.getTransportBed().getStorage().isEmpty());
    }

}

