package src;

public class CarPlatform implements Platform{
    private boolean isRampDown;
    CarPlatform(){
        isRampDown = true;
    }
    public void rampDown(){
        isRampDown = true;
    }
    public void rampUp(){
        isRampDown = false;
    }
    public boolean isRampDown(){
        return isRampDown;
    }
}
