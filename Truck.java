//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;

class Truck extends Vehicle {
    private boolean platformIsUp;

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double xPosition, double yPosition, int direction) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, xPosition, yPosition, direction);
    }

    public boolean isPlatformIsUp() {
        return this.platformIsUp;
    }

    public void setPlatformIsUp(boolean platformIsUp) {
        this.platformIsUp = platformIsUp;
    }

    public void checkPlatformMovementException() {
        if (this.getCurrentSpeed() != 0.0D) {
            throw new MoveWithRaisedPlatformException("You cannot raise platform while moving!");
        }
    }

    public void move() {
        if (!this.platformIsUp) {
            super.move();
        } else {
            throw new MoveWithRaisedPlatformException("");
        }
    }
}
