package Model;
import java.util.ArrayList;

public interface WorldObserver{
    public void update(ArrayList<? extends DrawableWithPosition> newobjects);
}