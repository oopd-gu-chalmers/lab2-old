package Model;
public class VehicleCreator {
    public static Vehicle getVolvo(){
        return new Volvo240();
    }
    public static Vehicle getSaab(){
        return new Saab95();
    }
    public static Vehicle getScania(){
        return new Scania();
    }
    public static Vehicle getVolvoFM9(){ //Står addCarTransport i UML men den är abstract
        return new VolvoFM9();
    }
}
