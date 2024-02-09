import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class WorkshopTest {
    private Workshop<Vehicle> CommonWorkshop;
    private Saab95 TestSaab1;
    private Saab95 TestSaab2;
    private Scania TestTruck;

    @BeforeEach
    public void setupTestCarTransport() {
        CommonWorkshop = new Workshop<Vehicle>(0, 0, 2);
        TestSaab1 = new Saab95();
        TestSaab2 = new Saab95();
        TestTruck = new Scania();
    }
    @Test
    public void loadCorrect() {
        CommonWorkshop.load(TestSaab1);
        assertEquals(TestSaab1, CommonWorkshop.getCurrentLoad().pop());
    }
    @Test
    public void unloadInCorrectOrder() {
        CommonWorkshop.load(TestSaab1);
        CommonWorkshop.load(TestSaab2);
        assertEquals(TestSaab1, CommonWorkshop.unload());
    }
    @Test
    public void cantLoadMoreThanMax() {
        CommonWorkshop.load(TestSaab1);
        CommonWorkshop.load(TestSaab2);
        CommonWorkshop.load(TestTruck);
        assertEquals(2, CommonWorkshop.getCurrentLoad().size());
    }
    @Test
    public void cantLoadSameVehicleTwice() {
        CommonWorkshop.load(TestSaab1);
        CommonWorkshop.load(TestSaab1);
        assertEquals(1, CommonWorkshop.getCurrentLoad().size());
    }
    @Test
    public void cannotLoadWhileDistanceTooLong() {
        TestSaab1.startEngine();
        for (int i = 0; i < 6; i++){
            TestSaab1.gas(1);
        }
        TestSaab1.move();
        CommonWorkshop.load(TestSaab1);
        assertEquals(0, CommonWorkshop.getCurrentLoad().size());
    }
}
