import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {

    CarView frame;
    public void actionPerformed(ActionEvent e) {
        for (Vehicle vehicle : vehicles) {
            checkAndCorrectPosition(vehicle);
            vehicle.move();

            checkCollision(vehicle);
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }

    }}
