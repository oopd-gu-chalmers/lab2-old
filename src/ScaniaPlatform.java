package src;

public class ScaniaPlatform implements Platform {
    private double angle;
    private final double maxAngle;
    
    public ScaniaPlatform(double maxAngle){
        this.angle = 0;
        this.maxAngle = maxAngle;
    }
    public void rampUp(){
        changePlatform(10);
    }
    public void rampDown(){
        changePlatform(-10);
    }
    public double getPlatformAngle(){
        return angle;
    }
    public boolean isRampDown(){
        return angle == 0;
    }
    private void changePlatform(double angle){
            if (this.angle + angle >= maxAngle){
                this.angle = maxAngle;
            } else if (this.angle + angle <= 0){
                this.angle = 0;
            } else{
                this.angle += angle;
            }
    }
}
