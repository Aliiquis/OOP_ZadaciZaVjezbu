package fer.oop.zzv05.person;

public abstract class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public final boolean isOutstanding() {
        return getGrade() > 4.5;
    }

    public abstract double getGrade();

    @Override
    public String toString() {
        return id + ", " + name;
    }
}
