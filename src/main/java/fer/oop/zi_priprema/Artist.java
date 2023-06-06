package fer.oop.zi_priprema;

import java.util.Objects;

public class Artist {

    private final long id;
    private final String name;

    public Artist(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Artist parse(String line) {
        try {
            String[] split = line.split(";");
            long id = Long.parseLong(split[0]);
            String name = split[1];
            return new Artist(id, name);
        } catch (NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Artist other = (Artist) obj;
        return id == other.id && Objects.equals(name, other.name);
    }

}
