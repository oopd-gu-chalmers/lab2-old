public class Ramp {
    private boolean rampUp = true;

    public boolean isRampRaised() {
        return rampUp;
    }

    public void raiseRamp() {
        rampUp = true;

    }

    public void lowerRamp() {
        rampUp = false;
    }



}
