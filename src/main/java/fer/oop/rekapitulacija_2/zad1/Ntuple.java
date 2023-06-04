package fer.oop.rekapitulacija_2.zad1;

import java.util.Arrays;

public class Ntuple<T extends Comparable<T>> implements Comparable<Ntuple<T>> {
    private final T[] elements;

    @SafeVarargs
    public Ntuple(T... elements) {
        this.elements = elements;
    }

    public T get(int index) {
        return elements[index];
    }

    public void set(int index, T element) {
        elements[index - 1] = element;
    }

    public int size() {
        return elements.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ntuple<?> ntuple = (Ntuple<?>) o;
        return Arrays.equals(elements, ntuple.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

    @Override
    public int compareTo(Ntuple<T> o) {
        for (int i = 0; i < Math.min(this.size(), o.size()); i++) {
            if (this.elements[i].compareTo(o.elements[i]) != 0) {
                return this.elements[i].compareTo(o.elements[i]);
            }
        }
        return Integer.compare(this.size(), o.size());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < elements.length - 1; i++) {
            sb.append(elements[i]).append(", ");
        }
        sb.append(elements[elements.length - 1]).append(")");
        return sb.toString();
    }
}
