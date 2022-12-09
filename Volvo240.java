
import java.awt.Color;

class Volvo240 extends Car {
    private static final double trimFactor = 1.25D;

    public Volvo240() {
        super(4, 125.0D, 0.0D, Color.black, "Volvo240", 0.0D, 0.0D, 1);
    }

    public double speedFactor() {
        return this.getEnginePower() * 0.01D * 1.25D;
    }
}
