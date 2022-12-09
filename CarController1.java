
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CarController1 implements ActionListener {
    private CarController this$0;

    CarController1(CarController this$0) {
        this.this$0 = this$0;
    }

    public void actionPerformed(ActionEvent e) {
        this.this$0.gas(this.this$0.frame.gasAmount);
    }
}
