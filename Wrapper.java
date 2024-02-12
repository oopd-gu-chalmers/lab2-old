import java.awt.Point;
import java.awt.image.BufferedImage;

public abstract class Wrapper {
    BufferedImage image;
    Point position;
    
    public void setPosition(int x, int y) {
        this.position.setLocation(x,y);
    }
    public int getX(){
        return position.x;
    }
    public int getY() {
        return position.y;
    }
    public BufferedImage getImage() {
        return image;
    }
}
