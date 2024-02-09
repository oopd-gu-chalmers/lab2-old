public abstract class ObjectWithPosition {
    private double x_pos; // Coordinate Position x
    private double y_pos; // Coordinate Position y

    public double[] getCurrentPos() { // Added for test of move().
        double[] pos = {x_pos, y_pos};
        return pos;
    }
    protected void setCurrentPos(double x, double y) { // Added for test of move().
        x_pos = x;
        y_pos = y;
    }
}
