package fer.oop.zzv09.songs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;

public class Playlist {
    private String title;
    private List<Track> tracks;
    private final OptionalInt maxDuration;
    private int duration;

    public Playlist(String title) {
        this.title = title;
        this.tracks = new LinkedList<>();
        this.maxDuration = OptionalInt.empty();
        this.duration = 0;
    }

    public Playlist(String title, int maxDuration) {
        this.title = title;
        this.tracks = new LinkedList<>();
        this.maxDuration = OptionalInt.of(maxDuration);
        this.duration = 0;
    }

    public String getTitle() {
        return title;
    }

    public OptionalInt getMaxDuration() {
        return maxDuration;
    }

    public boolean add(Track track) {
        if (maxDuration.isPresent()) {
            if (track.getDuration() + duration > maxDuration.getAsInt()) return false;
        }
        tracks.add(track);
        duration += track.getDuration();
        return true;
    }

    public Track trackAt(int index) {
        return tracks.get(index - 1);
    }

    public void deleteAt(int index) {
        duration -= tracks.remove(index - 1).getDuration();
    }

    public void move(int position, int offset) {
        tracks.add(position + offset - 1, tracks.remove(position - 1));
    }

    public int count() {
        return tracks.size();
    }

    public int duration() {
        return duration;
    }

    public void invert() {
        Collections.reverse(tracks);
    }
}
