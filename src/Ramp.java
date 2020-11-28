public class Ramp {
    private boolean rampUp = true;

    /**
     * Sets ramp up
     */
    public void raiseRamp() {
        rampUp = true;

    }

    /**
     * Sets the ramp down
     */
    public void lowerRamp() {
        rampUp = false;
    }

    /**
     * Checks if ramp is up
     * @return a boolean representing if ramp is up or down
     */
    public boolean isRampRaised() {
        return rampUp;
    }



}
