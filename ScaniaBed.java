public class ScaniaBed {

    private int angle = 0;


    protected void raise() {
        if (this.angle <= 60)
            this.angle  += 10;
        else {
            this.angle = 70;
        }
    }


    protected void lower() {
        if (this.angle >= 10)
            this.angle -= 10;
        else {
            this.angle = 0;
        }
    }

    protected int getAngle(){return this.angle;}

    protected void setAngle(int angle){
        if (angle >= 0 && angle <= 70)
            this.angle = angle;
        else
            throw new IllegalArgumentException("Angle must be between 0 and 70");
    }
}