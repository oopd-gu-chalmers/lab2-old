import org.junit.Test;


import java.awt.*;

import static org.junit.Assert.*;

public class CarTransporterTest {
    CarTransporter cartransporter = new CarTransporter(2, 350, 0, Color.red, "Cartransporter",
            3);
    Volvo240 volvo240 = new Volvo240(4, 100, 0, Color.black, "Volvo240");

    @Test
    public void isCarCloseEnoughCorrect() {
        assertTrue(cartransporter.isCarCloseEnough(volvo240));
    }

    @Test
    public void isCarCloseEnoughWrong() {
        volvo240.setX(6);
        volvo240.setY(0);
        cartransporter.setX(0);
        cartransporter.setY(0);
        assertFalse(cartransporter.isCarCloseEnough(volvo240));
    }


    @Test
    public void setRampUp() {
        cartransporter.raiseRamp();
        assertTrue(cartransporter.isRampRaised());
    }

    @Test
    public void setRampDown() {
        cartransporter.lowerRamp();
        assertFalse(cartransporter.isRampRaised());
    }

    @Test
    public void canInteractWithCarIfSpeedNotZero() {
        CarTransporter cartransporter = new CarTransporter(3, 350, 2, Color.red, "Cartransporter",
                3);
        assertFalse(cartransporter.canLoadOrUnloadCar());

    }


    @Test
    public void loadCar() {
        CarTransporter cartransporter = new CarTransporter(3, 350, 0, Color.red, "Cartransporter",
                2);
        Volvo240 volvo1 = new Volvo240(4, 100, 0, Color.black, "Volvo1");
        Volvo240 volvo2 = new Volvo240(4, 100, 0, Color.black, "Volvo2");
        cartransporter.lowerRamp();
        cartransporter.loadCar(volvo1);
        cartransporter.loadCar(volvo2);
        assertEquals("[Volvo1, Volvo2]", cartransporter.carsToString());
    }

    @Test
    public void loadCarWithoutToString() {
        CarTransporter cartransporter = new CarTransporter(3, 350, 0, Color.red, "Cartransporter",
                2);
        Volvo240 volvo1 = new Volvo240(4, 100, 0, Color.black, "Volvo1");
        Volvo240 volvo2 = new Volvo240(4, 100, 0, Color.black, "Volvo2");
        cartransporter.lowerRamp();
        cartransporter.loadCar(volvo1);
        cartransporter.loadCar(volvo2);
        assertEquals(volvo2, cartransporter.getCars().get(1));
    }

    @Test
    public void loadCarIfStackFull() {
        CarTransporter cartransporter = new CarTransporter(3, 350, 0, Color.red, "Cartransporter",
                2);
        Volvo240 volvo1 = new Volvo240(4, 100, 0, Color.black, "Volvo1");
        Volvo240 volvo2 = new Volvo240(4, 100, 0, Color.black, "Volvo2");
        Volvo240 volvo3 = new Volvo240(4, 100, 0, Color.black, "Volvo3");
        cartransporter.lowerRamp();
        cartransporter.loadCar(volvo1);
        cartransporter.loadCar(volvo2);
        cartransporter.loadCar(volvo3);
        assertEquals("[Volvo1, Volvo2]", cartransporter.carsToString());

    }

    @Test
    public void removeCarWorks() {
        CarTransporter cartransporter = new CarTransporter(3, 350, 0, Color.red, "Cartransporter",
                2);
        Volvo240 volvo1 = new Volvo240(4, 100, 0, Color.black, "Volvo1");
        Volvo240 volvo2 = new Volvo240(4, 100, 0, Color.black, "Volvo2");
        Volvo240 volvo3 = new Volvo240(4, 100, 0, Color.black, "Volvo3");
        cartransporter.lowerRamp();
        cartransporter.loadCar(volvo1);
        cartransporter.loadCar(volvo2);
        cartransporter.unloadCar();
        cartransporter.unloadCar();
        assertEquals("[]", cartransporter.carsToString());
    }

    @Test
    public void removeCarIfNone() {
        CarTransporter cartransporter = new CarTransporter(3, 350, 0, Color.red, "Cartransporter",
                2);
        Volvo240 volvo1 = new Volvo240(4, 100, 0, Color.black, "Volvo1");
        Volvo240 volvo2 = new Volvo240(4, 100, 0, Color.black, "Volvo2");
        Volvo240 volvo3 = new Volvo240(4, 100, 0, Color.black, "Volvo3");
        cartransporter.lowerRamp();
        cartransporter.loadCar(volvo1);
        cartransporter.loadCar(volvo2);
        cartransporter.unloadCar();
        cartransporter.unloadCar();
        cartransporter.unloadCar();
        cartransporter.unloadCar();
        assertEquals("[]", cartransporter.carsToString());
    }

    @Test
    public void gasCarTransporter() {
        CarTransporter cartransporter = new CarTransporter(3, 350, 0, Color.red, "Cartransporter",
                2);
        cartransporter.gas(1);
        assertEquals(3.5, cartransporter.getCurrentSpeed(), 0.001);
    }
    @Test
    public void doCarsLoadedAlsoMove() {
        CarTransporter cartransporter = new CarTransporter(3, 350, 0, Color.red, "Cartransporter",
                2);
        Volvo240 volvo1 = new Volvo240(4, 100, 0, Color.black, "Volvo1");
        cartransporter.lowerRamp();
        cartransporter.loadCar(volvo1);
        cartransporter.raiseRamp();
        cartransporter.gas(1);
        cartransporter.move();
        assertEquals(volvo1.getY(), cartransporter.getY(), 0.001);
    }
    @Test
    public void canCarTransporterLoadItself() {
        CarTransporter cartransporter = new CarTransporter(3, 350, 0, Color.red, "Cartransporter",
                2);


    }
}

