

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

class CarController$TimerListener implements ActionListener {
    private CarController this$0;

    private CarController$TimerListener(CarController var1) {
        this.this$0 = var1;
    }

    public void actionPerformed(ActionEvent e) {
        for(Iterator var2 = this.this$0.vehicles.iterator(); var2.hasNext(); this.this$0.frame.drawPanel.repaint()) {
            Vehicle vehicle = (Vehicle)var2.next();
            vehicle.move();
            int x = (int)Math.round(vehicle.getxPosition());
            int y = (int)Math.round(vehicle.getyPosition());
            if (vehicle instanceof Volvo240) {
                this.this$0.frame.drawPanel.moveVolvo(x, y);
            }

            if (vehicle instanceof Saab95) {
                this.this$0.frame.drawPanel.moveSaab(x, y);
            }

            if (vehicle instanceof Scania) {
                this.this$0.frame.drawPanel.moveScania(x, y);
            }

            if (vehicle.getyPosition() >= 500.0D) {
                vehicle.setDirection(3);
            }

            if (vehicle.getyPosition() <= 0.0D) {
                vehicle.setDirection(1);
            }
        }

    }
}
