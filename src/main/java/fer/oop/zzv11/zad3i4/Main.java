package fer.oop.zzv11.zad3i4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Person.loadPersons();
        class MyFormat implements PersonDataFormatter {

            @Override
            public String format(Person p) {
                return String.format("%s %s, %s, %s, %d",
                        p.getName(),
                        p.getSurname(),
                        p.getBirthday(),
                        p.getGender(),
                        p.getAge());
            }
        }

        System.out.println("By inner class:");
        PersonDataFormatter.printAll(persons, new MyFormat());

        System.out.println("By anon class:");
        PersonDataFormatter.printAll(persons, new PersonDataFormatter() {
            @Override
            public String format(Person p) {
                return String.format("%s %s, %s, %s, %d",
                        p.getName(),
                        p.getSurname(),
                        p.getBirthday(),
                        p.getGender(),
                        p.getAge());
            }
        });

        System.out.println("By lambda:");
        PersonDataFormatter.printAll(persons, (p) -> String.format("%s %s, %s, %s, %d",
                p.getName(),
                p.getSurname(),
                p.getBirthday(),
                p.getGender(),
                p.getAge()));
    }
}
