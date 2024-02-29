package Model;
import java.awt.*;

public class VolvoFM9 extends CarTransport{
    public VolvoFM9 () {
        super(2, Color.gray, 100, "Volvo FM9", 2, 600, 300);
    }

    protected double speedFactor() {
        double factor;
        if (getCurrentLoad().size() > 0) {
            factor = 0.01 / getCurrentLoad().size(); //Speedfactor impacted by total weight
        } else {
            factor = 0.01;
        }
        return getEnginePower() * factor; 
    }
}
