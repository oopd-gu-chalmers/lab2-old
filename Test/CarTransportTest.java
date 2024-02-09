import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarTransportTest{
    private VolvoFM9 TestVolvoFM9;
    private VolvoFM9 TestVolvoFM91;
    private Saab95 TestCar1;
    private Saab95 TestCar2;
    private Saab95 TestCar3;

    @BeforeEach
    public void setupTestCarTransport() {
        TestVolvoFM9 = new VolvoFM9();
        TestVolvoFM91 = new VolvoFM9();
        TestCar1 = new Saab95();
        TestCar2 = new Saab95();
        TestCar3 = new Saab95();
    }
    @Test
    public void loadTest () {
        TestVolvoFM9.load(TestCar1);
        assertEquals(1, TestVolvoFM9.getCurrentLoad().size());
    }
    @Test
    public void loadingOnlyWithRampDown() {
        TestVolvoFM9.raiseTilt();
        TestVolvoFM9.load(TestCar1);
        assertEquals(0, TestVolvoFM9.getCurrentLoad().size());
    }
    @Test
    public void maxLoadTest() {
        TestVolvoFM9.load(TestCar1);
        TestVolvoFM9.load(TestCar2);
        TestVolvoFM9.load(TestCar3);
        assertEquals(2, TestVolvoFM9.getCurrentLoad().size());
    }
    @Test
    public void unloadInCorrectOrder() {
        TestVolvoFM9.load(TestCar1);
        TestVolvoFM9.load(TestCar2);
        Car unloaded_car = TestVolvoFM9.unload();
        assertEquals(unloaded_car, TestCar2);
    }
    @Test
    public void positionMatching() {
        TestVolvoFM9.load(TestCar1);
        TestVolvoFM9.startEngine();
        TestVolvoFM9.gas(1);
        TestVolvoFM9.move();
        assertArrayEquals(TestVolvoFM9.getCurrentPos(), TestCar1.getCurrentPos());
    }
    @Test
    public void cannotLoadWhileDistanceTooLong() {
        TestCar1.startEngine();
        for (int i = 0; i < 6; i++){
            TestCar1.gas(1);
        }
        TestCar1.move();
        TestVolvoFM9.load(TestCar1);
        assertEquals(0, TestVolvoFM9.getCurrentLoad().size());
    }
    @Test
    public void carTransportsIndependent() {
        TestVolvoFM9.load(TestCar1);
        TestVolvoFM91.load(TestCar2);
        TestVolvoFM91.load(TestCar3);
        assertEquals(1, TestVolvoFM9.getCurrentLoad().size());
        assertEquals(2, TestVolvoFM91.getCurrentLoad().size());
    }
}
