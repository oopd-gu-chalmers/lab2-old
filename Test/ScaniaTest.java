import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ScaniaTest{
    private Scania TestScania;
    @BeforeEach
    public void setupTestScania() {
        TestScania = new Scania();
    }
    @Test
    public void cantStartEngineWhilePlatformRaised() {
        TestScania.raiseTilt();
        TestScania.startEngine();
        assertEquals(TestScania.getCurrentSpeed(), 0);
    }
}