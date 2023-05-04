package fer.oop.zzv09.songs;

public class Track {
    private final String title;
    private final String author;
    private final int duration;

    public Track(String title, String author, int duration) {
        this.title = title;
        this.author = author;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return author + ": " + title;
    }
}
