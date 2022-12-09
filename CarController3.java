

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CarController3 implements ActionListener {
    private CarController this$0;

    CarController3(CarController this$0) {
        this.this$0 = this$0;
    }

    public void actionPerformed(ActionEvent e) {
        this.this$0.turboOn();
    }
}
