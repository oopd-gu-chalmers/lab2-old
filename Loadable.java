import java.util.Deque;

public interface Loadable<T extends ObjectWithPosition>{ //Loadable objects can load and unload a generic type T.
    public void load(T vehicle); 
    public T unload();
    double[] getCurrentPos();
    int getMaxLoad();
    Deque<T> getCurrentLoad();
}
