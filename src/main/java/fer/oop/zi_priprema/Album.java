package fer.oop.zi_priprema;

import java.util.Objects;

public class Album {

    public static final Long SINGLE = 0l;

    private final long id;
    private final String title;
    private final int year;
    private final long artistId;

    public Album(long id, String title, int year, long artistId) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.artistId = artistId;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public long getArtistId() {
        return artistId;
    }

    public int getYear() {
        return year;
    }

    public static Album parse(String csvLine) {
        String[] args = csvLine.split(";");
        return new Album(Integer.parseInt(args[0]), args[1], Integer.parseInt(args[2]), Long.parseLong(args[3]));
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistId, id, title, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Album other = (Album) obj;
        return artistId == other.artistId && id == other.id && Objects.equals(title, other.title) && year == other.year;
    }
}
