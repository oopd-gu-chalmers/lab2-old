public class VehicleCreator {
    Vehicle getVolvo(){
        return new Volvo240();
    }
    Vehicle getSaab(){
        return new Saab95();
    }
    Vehicle getScania(){
        return new Scania();
    }
    Vehicle getVolvoFM9(){ //Står addCarTransport i UML men den är abstract
        return new VolvoFM9();
    }
}
