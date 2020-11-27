public class Turbo {
    private boolean turboOn;
    /**
     * Sets turboOn true.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     *  Sets turboOn false.
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * @return a boolean representing turboOn is true or false.
     */
    public boolean isTurboOn() {
        return turboOn;
    }

}
