

import java.awt.Color;

class Scania extends Truck {
    private int platformAngle;

    public Scania() {
        super(2, 125.0D, 0.0D, Color.blue, "R 450", 0.0D, 0.0D, 1);
    }

    public int getPlatformAngle() {
        return this.platformAngle;
    }

    public void setPlatformAngle(int platformAngle) {
        this.platformAngle = platformAngle;
    }

    public void raisePlatform(int amount) {
        super.checkPlatformMovementException();
        this.platformAngle = Math.min(this.platformAngle + amount, 70);
        if (this.platformAngle != 0) {
            this.setPlatformIsUp(true);
        }

    }

    public void lowerPlatform(int amount) {
        super.checkPlatformMovementException();
        this.platformAngle = Math.max(this.platformAngle - amount, 0);
        if (this.platformAngle == 0) {
            this.setPlatformIsUp(false);
        }

    }
}
