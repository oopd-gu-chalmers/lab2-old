public class VehicleCreator {
    static Vehicle getVolvo(){
        return new Volvo240();
    }
    static Vehicle getSaab(){
        return new Saab95();
    }
    static Vehicle getScania(){
        return new Scania();
    }
    static Vehicle getVolvoFM9(){ //Står addCarTransport i UML men den är abstract
        return new VolvoFM9();
    }
}
