import java.awt.*;

public class CarTransport extends Truck implements Loadable<Car> {
    private final CarTransportBed transportBed = new CarTransportBed();
    public CarTransport(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }


    @Override
    public void move(){
        if (transportBed.getIsRaised()){
            super.move();
            if (!transportBed.getStorage().isEmpty()){
                for (Car car : transportBed.getStorage()) {
                    car.setXPos(this.getXPos());
                    car.setYPos(this.getYPos());}}
        else {
            throw new IllegalStateException("Can't move when ramp is down");}

    }}

    public void load(Car car){
        double d = Math.sqrt(Math.pow(this.getXPos()-car.getXPos(),2) + Math.pow(this.getYPos()-car.getYPos(),2));
        if (!transportBed.getIsRaised() && d <= 1)
            transportBed.getStorage().push(car);
        else
            throw new IllegalStateException("Can't load when ramp is raised");
    }

    public Car unload() {
        Car outCar = null;
        if (!transportBed.getStorage().isEmpty() && !transportBed.getIsRaised()) {
            outCar = transportBed.getStorage().pop();
            double xOffset = -1 * Math.cos(this.getDirection());
            double yOffset = -1 * Math.sin(this.getDirection());
            outCar.setXPos(this.getXPos() + xOffset);
            outCar.setYPos(this.getYPos() + yOffset);
        }
        return outCar;
    }

    @Override
    public void gas(double amount){
        if (!transportBed.getIsRaised())
            throw new IllegalStateException("Can't gas when ramp is down.");
        else
            super.gas(amount);
    };

    protected boolean getBedIsRaised() {
        return transportBed.getIsRaised();
    }


    @Override
    protected void raiseBed() {
        transportBed.raise();
    }

    @Override
    protected void lowerBed() {
        transportBed.lower();
    }

    protected CarTransportBed getTransportBed(){
        return transportBed;
    }
}
