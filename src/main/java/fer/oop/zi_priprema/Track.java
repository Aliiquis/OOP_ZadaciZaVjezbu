package fer.oop.zi_priprema;

import java.util.Objects;

public class Track {

    private final long id;
    private final String name;
    private final long genreId;
    private final long albumId;
    private final int trackLength; // seconds
    private final String composer;

    public Track(long id, String name, long genreId, long albumId, int trackLength, String composer) {
        this.id = id;
        this.name = name;
        this.genreId = genreId;
        this.albumId = albumId;
        this.trackLength = trackLength;
        this.composer = composer;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getGenreId() {
        return genreId;
    }

    public long getAlbumId() {
        return albumId;
    }

    public int getTrackLength() {
        return trackLength;
    }

    public String getComposer() {
        return composer;
    }

    public static Track parse(String line) {
        try {
            String[] split = line.split(";");
            long id = Long.parseLong(split[0]);
            String name = split[1];
            long genreId = Long.parseLong(split[2]);
            long album = Util.parseOrDefault(split[3], Album.SINGLE);
            int length = Integer.parseInt(split[4]);
            String composer = split[5];
            return new Track(id, name, genreId, album, length, composer);
        } catch (NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumId, composer, genreId, id, name, trackLength);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Track other = (Track) obj;
        return albumId == other.albumId && Objects.equals(composer, other.composer) && genreId == other.genreId
                && id == other.id && Objects.equals(name, other.name) && trackLength == other.trackLength;
    }


}
