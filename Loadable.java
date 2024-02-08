public interface Loadable<T extends Vehicle> {
    void load(T vehicle);

    T unload();
}
