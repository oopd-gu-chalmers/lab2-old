import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class World implements ActionListener{
    private static final int delay = 50;
    private Timer timer = new Timer(delay, this);
    ArrayList<Vehicle> cars = new ArrayList<>();
    Workshop<Volvo240> workshop = new Workshop<Volvo240>(500, 0, 2);
    ArrayList<WorldObserver> observers= new ArrayList<WorldObserver>();
    ArrayList<DrawableWithPosition> drawobjects = new ArrayList<DrawableWithPosition>(); //Lite redundant men smidigt
    
    public World(){
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        checkForCollisionWithWorkshop();
        // checkForCollisionWithBorder(frame.getPreferredSize().getWidth()); Detta behöver vi lösa, ska World få tillgång till border width?
        moveAllCars();
        notifyofchange();
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars)
        {
            try {
                car.gas(gas);
            } catch(Exception IllegalStateException) {
                continue;
            }
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars)
        {
            car.brake(brake);
        }
    }

    void startEngines() {
        for (Vehicle car : cars)
        {
            car.startEngine();
        }
    }

    void stopEngines() {
        for (Vehicle car : cars)
        {
            car.stopEngine();
        }
    }

    void saabTurboOn() {
        for (Vehicle car : cars)
        {
            if (car instanceof Saab95){
                Saab95 saab = (Saab95) car;
                saab.setTurboOn();
            }    
        }
    }

    void saabTurboOff() {
        for (Vehicle car : cars)
        {
            if (car instanceof Saab95){
                Saab95 saab = (Saab95) car;
                saab.setTurboOff();
            }    
        }
    }

    void PlatformDown() {
        for (Vehicle car : cars)
        {
            if (car instanceof TiltablePosterior){
                TiltablePosterior tiltable = (TiltablePosterior) car;
                tiltable.lowerTilt();
            }    
        }
    }

    void PlatformUp() {
        for (Vehicle car : cars)
        {
            if (car instanceof TiltablePosterior){
                TiltablePosterior tiltable = (TiltablePosterior) car;
                tiltable.raiseTilt();
            }    
        }
    }

    void checkForCollisionWithWorkshop() {
        for (Vehicle car : cars) {
            double car_x = car.getCurrentPos()[0] + car.getImage().getWidth() / 2; //VolvoImage not optimal, but easiest. should define constant for image size.
            double car_y = car.getCurrentPos()[1] + car.getImage().getHeight() / 2;
            double workshop_x = workshop.getCurrentPos()[0] + car.getImage().getWidth() / 2; //Same here.
            double workshop_y = workshop.getCurrentPos()[1] + car.getImage().getHeight() / 2;
            double distance = Math.sqrt(Math.pow(workshop_x - car_x, 2) + Math.pow(workshop_y - car_y, 2));
            if (car instanceof Volvo240) {
                workshop.load((Volvo240) car);
                if (workshop.getCurrentLoad().contains(car)) {
                    car.stopEngine();
                }
            }
        }
    }

    void moveAllCars(){
        for (Vehicle car : cars){
            car.move();
        }
    }
    void checkForCollisionWithBorder(double borderWidth){
        for (Vehicle car: cars){
        if (car.getCurrentPos()[0] + car.getImage().getWidth() >= borderWidth){ // frame.drawPanel.volvoImage volvoImage is very hard coded change!
            car.setDirection(car.getDirection() + 180);
        } else if (car.getCurrentPos()[0] < 0) {
            car.setDirection(car.getDirection() - 180);
        }
    }
    }
    void notifyofchange(){
        for (WorldObserver o:observers){
            o.update(drawobjects);
        }
    }    

    ArrayList<Vehicle> getCars(){   //När används denna?
        return cars;
    }

    void AddVolvo(){
        cars.add(new Volvo240());
        updateDrawObjects();
    }
    void AddSaab(){
        cars.add(new Saab95());
        updateDrawObjects();
    }
    void AddScania(){
        cars.add(new Scania());
        updateDrawObjects();
    }
    void AddVolvoFM9(){ //Står addCarTransport i UML men den är abstract
        cars.add(new VolvoFM9());
        updateDrawObjects();
    }
    void AddObserver(WorldObserver obs){    //Smidigt sätt att lägga til observers
        observers.add(obs);
    }
    void updateDrawObjects(){
        drawobjects.addAll(cars);
        drawobjects.add(workshop);
    }

}
