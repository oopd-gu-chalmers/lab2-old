

import java.awt.Color;

class Saab95 extends Car {
    private boolean turboOn = false;

    public Saab95() {
        super(2, 125.0D, 0.0D, Color.red, "Saab95", 0.0D, 100.0D, 1);
        this.stopEngine();
    }

    public void setTurboOn() {
        this.turboOn = true;
    }

    public void setTurboOff() {
        this.turboOn = false;
    }

    public double speedFactor() {
        double turbo = 1.0D;
        if (this.turboOn) {
            turbo = 1.3D;
        }

        return this.getEnginePower() * 0.01D * turbo;
    }
}
