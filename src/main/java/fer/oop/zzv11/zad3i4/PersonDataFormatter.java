package fer.oop.zzv11.zad3i4;

public interface PersonDataFormatter {
    String format(Person p);

    default void print(Person p) {
        System.out.println(format(p));
    }

    static void printAll(Iterable<Person> persons, PersonDataFormatter formatter) {
        for (Person person : persons) {
            System.out.println(formatter.format(person));
        }
    }
}
