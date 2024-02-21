import java.awt.image.BufferedImage;

public interface DrawableWithPosition {
    public double[] getCurrentPos();
    public void setCurrentPos(double x, double y);
    public BufferedImage getImage();
    public void setImage(String filepath);
}    
