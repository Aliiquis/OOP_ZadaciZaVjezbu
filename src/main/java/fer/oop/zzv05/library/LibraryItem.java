package fer.oop.zzv05.library;

public abstract class LibraryItem {
    private int id;
    private String name;

    public LibraryItem(int id, String name) {
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

    public abstract int getLoanPeriod();

    @Override
    public String toString() {
        return id + ' ' + name;
    }
}
