package fer.oop.zzv11.zad8;

import fer.oop.zzv11.zad3i4.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Sequence<T> {
    private final List<T> values;

    @SafeVarargs
    public Sequence(T... values) {
        this.values = new ArrayList<>();
        this.values.addAll(Arrays.asList(values));
    }

    public Sequence(List<T> values) {
        this.values = values;
    }

    public Sequence<T> filter(Predicate<T> predicate) {
        Sequence<T> newSequence = new Sequence<>(values);
        for (T t : new ArrayList<>(values)) {
            if (!predicate.test(t)) {
                newSequence.values.remove(t);
            }
        }
        return newSequence;
    }

    public <R> Sequence<R> map(Function<? super T, ? extends R> mapper) {
        List<R> rValues = new ArrayList<>();
        for (T t : values) {
            R r = mapper.apply(t);
            rValues.add(r);
        }
        return new Sequence<>(rValues);
    }

    public void forEach(Consumer<T> action) {
        for (T t : values) {
            action.accept(t);
        }
    }

    public List<T> toList() {
        return values;
    }

    public Boolean all(Predicate<T> predicate) {
        for (T t : values) {
            if (!predicate.test(t)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> result = new Sequence<>("OOP", "is", "your", "world", ".")
                .filter(s -> true)
                .map(String::length)
                .toList();
        System.out.println(result);

        new Sequence<>("OOP", "is", "your", "world", ".")
                .filter((s) -> s.length() < 4)
                .map((s) -> {
                    if (s.length() % 2 == 0)
                        return s + " string has an even number of characters";
                    return s + " string has an odd number of characters";
                })
                .forEach(System.out::println);

        boolean areAllVragec = new Sequence<>(Person.loadPersons())
                .all((p) -> p.getSurname().equals("Vragec"));
        System.out.println(areAllVragec);
    }
}
