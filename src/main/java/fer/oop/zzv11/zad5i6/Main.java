package fer.oop.zzv11.zad5i6;

import fer.oop.zzv11.zad3i4.Gender;
import fer.oop.zzv11.zad3i4.Person;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing methods:");
        List<Person> persons = Person.loadPersons();
        printPersons(persons, (p) -> p.getGender().equals(Gender.FEMALE), Person::getName);
        processPersons(persons, (p) -> p.getAge() < 50 && p.getGender().equals(Gender.MALE), (p) -> System.out.println(p.getBirthday()));
        processData(persons, (t) -> t.getId() > 5, (t) -> t, System.out::println);

        System.out.println("\nPrinting map key:id, value:name+surname");
        Map<Integer, String> personsMap = convertIterablePersonsToMap(persons);
        personsMap.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("\nSorted values:");
        List<String> values = new LinkedList<>(personsMap.values());
        values.sort(String::compareTo);
        values.forEach(System.out::println);

        System.out.println("\nRemoved if name longer than 11:");
        values.removeIf((v) -> v.length() > 11);
        values.forEach(System.out::println);

        System.out.println("\nPrinting map key:id, value:name");
        Map<Integer, String> map = convertIterableToMap(persons, Person::getId, Person::getName);
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }

    public static void printPersons(Iterable<Person> persons, Predicate<Person> criteria,
                                    Function<Person, String> formatter) {
        for (Person p : persons) {
            if (criteria.test(p)) {
                System.out.println(formatter.apply(p));
            }
        }
    }

    public static void processPersons(Iterable<Person> persons, Predicate<Person> criteria,
                                      Consumer<Person> action) {
        for (Person p : persons) {
            if (criteria.test(p)) {
                action.accept(p);
            }
        }
    }

    public static <T, R> void processData(Iterable<T> data, Predicate<T> criteria,
                                          Function<T, R> mapper, Consumer<R> action) {
        for (T t : data) {
            if (criteria.test(t)) {
                R r = mapper.apply(t);
                action.accept(r);
            }
        }
    }

    static Map<Integer, String> convertIterablePersonsToMap(
            Iterable<? extends Person> persons) {
        Map<Integer, String> personsMap = new TreeMap<>();
        for (Person p : persons) {
            personsMap.put(p.getId(), p.getName() + " " + p.getSurname());
        }
        return personsMap;
    }

    static <K, V, E> Map<K, V> convertIterableToMap(Iterable<? extends E> elements,
                                                    Function<E, K> keyFunction, Function<E, V> valueFunction) {
        Map<K, V> map = new HashMap<>();
        for (E e : elements) {
            K key = keyFunction.apply(e);
            V value = valueFunction.apply(e);
            map.put(key, value);
        }
        return map;
    }
}
