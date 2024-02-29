public interface Observable {
    void AddObserver(WorldObserver obs);
    void notifyofchange();
}
