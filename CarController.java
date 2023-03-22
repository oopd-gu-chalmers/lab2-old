import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Timer;

public class CarController {
    private final int delay = 50;
    private Timer timer = new Timer(50, new CarController.TimerListener());
    CarView frame;
    public ArrayList<Vehicle> vehicles = new ArrayList();

    public CarController() {
    }

    public static void main(String[] args) {
        CarController cc = new CarController();
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Scania());
        cc.frame = new CarView("CarSim 1.0");
        cc.takeInput();
        cc.timer.start();
    }

    public void takeInput() {
        this.frame.gasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("tesy");
                CarController.this.gas(CarController.this.frame.gasAmount);
            }
        });
        this.frame.brakeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CarController.this.brake(CarController.this.frame.gasAmount);
            }
        });
        this.frame.turboOnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CarController.this.turboOn();
            }
        });
        this.frame.turboOffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CarController.this.turboOff();
            }
        });
        this.frame.stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CarController.this.stopAllCars();
            }
        });
        this.frame.startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CarController.this.startAllCars();
            }
        });
    }

    void gas(int amount) {
        double gas = (double)amount / 100.0D;
        Iterator var4 = this.vehicles.iterator();

        while(var4.hasNext()) {
            Vehicle vehicle = (Vehicle)var4.next();
            vehicle.gas(gas);
        }

    }

    void brake(int amount) {
        double brake = (double)amount / 100.0D;
        Iterator var4 = this.vehicles.iterator();

        while(var4.hasNext()) {
            Vehicle vehicle = (Vehicle)var4.next();
            vehicle.brake(brake);
        }

    }

    void turboOn() {
        Iterator var1 = this.vehicles.iterator();

        while(var1.hasNext()) {
            Vehicle vehicle = (Vehicle)var1.next();
            if (vehicle instanceof Saab95) {
                ((Saab95)vehicle).setTurboOn();
            }
        }

    }

    void turboOff() {
        Iterator var1 = this.vehicles.iterator();

        while(var1.hasNext()) {
            Vehicle vehicle = (Vehicle)var1.next();
            if (vehicle instanceof Saab95) {
                ((Saab95)vehicle).setTurboOff();
            }
        }

    }

    void stopAllCars() {
        Iterator var1 = this.vehicles.iterator();

        while(var1.hasNext()) {
            Vehicle vehicle = (Vehicle)var1.next();
            vehicle.stopEngine();
        }

    }

    void startAllCars() {
        Iterator var1 = this.vehicles.iterator();

        while(var1.hasNext()) {
            Vehicle vehicle = (Vehicle)var1.next();
            vehicle.startEngine();
        }

    }

    private class TimerListener implements ActionListener {
        private TimerListener() {
        }

        public void actionPerformed(ActionEvent e) {
            for(Iterator var2 = CarController.this.vehicles.iterator(); var2.hasNext(); CarController.this.frame.drawPanel.repaint()) {
                Vehicle vehicle = (Vehicle)var2.next();
                vehicle.move();
                int x = (int)Math.round(vehicle.getxPosition());
                int y = (int)Math.round(vehicle.getyPosition());
                if (vehicle instanceof Volvo240) {
                    CarController.this.frame.drawPanel.moveVolvo(x, y);
                }

                if (vehicle instanceof Saab95) {
                    CarController.this.frame.drawPanel.moveSaab(x, y);
                }

                if (vehicle instanceof Scania) {
                    CarController.this.frame.drawPanel.moveScania(x, y);
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
}
