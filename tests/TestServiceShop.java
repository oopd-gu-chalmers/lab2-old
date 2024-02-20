import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.util.NoSuchElementException;

public class TestServiceShop {
    private ServiceShop<Volvo240> volvoShop;
    private Volvo240 volvoCar;

    @BeforeEach
    public void setUp() {
        volvoShop = new ServiceShop<>(5);
        volvoCar = new Volvo240(4, 100, Color.BLACK, "Volvo240");
    }

    @Test
    public void testLoadCar() {
        volvoShop.load(volvoCar);
        assertFalse(volvoShop.getStorage().isEmpty());
    }

    @Test
    public void testUnloadCar() {
        volvoShop.load(volvoCar);
        assertEquals(volvoCar, volvoShop.unload());
    }

    @Test
    public void testCapacityLimit() {
        for (int i = 0; i < 5; i++) {
            volvoShop.load(new Volvo240(4, 100, Color.BLACK, "Volvo240-" + i));
        }
        assertThrows(IllegalStateException.class, () -> volvoShop.load(new Volvo240(4, 100, Color.BLACK, "ExtraVolvo")));
    }

    @Test
    public void testUnloadEmptyShop() {
        assertThrows(NoSuchElementException.class, () -> volvoShop.unload());
    }
}
