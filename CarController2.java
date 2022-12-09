
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CarController2 implements ActionListener {
    private CarController this$0;

    CarController2(CarController this$0) {
        this.this$0 = this$0;
    }

    public void actionPerformed(ActionEvent e) {
        this.this$0.brake(this.this$0.frame.gasAmount);
    }
}
