package fer.oop.rekapitulacija.zad4;

public interface Loadable {
    boolean add(Object o);

    boolean remove(Object o);

    default double getWeight() {
        return 0;
    }
}
