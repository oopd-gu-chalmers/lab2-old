import java.awt.*;

public class Saab95 extends Car{
    private boolean turboOn;
    
    public Saab95(){
        super(2,Color.red,125,"Saab95");
        setSize(500, 180);
	    turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public boolean statusTurboOn(){
        return turboOn;
    }
    public void setTurboOff(){
	    turboOn = false;
    }
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
