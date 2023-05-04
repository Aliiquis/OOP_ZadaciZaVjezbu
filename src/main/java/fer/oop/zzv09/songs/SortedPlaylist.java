package fer.oop.zzv09.songs;

public class SortedPlaylist extends Playlist {
    private boolean ascending;

    public SortedPlaylist(String title) {
        super(title);
        this.ascending = true;
    }

    public SortedPlaylist(String title, int maxDuration) {
        super(title, maxDuration);
        this.ascending = true;
    }

    @Override
    public void move(int position, int offset) {
        throw new RuntimeException("You ain't movin shit bruh");
    }

    @Override
    public boolean add(Track track) {
        if (super.add(track)) {
            if (ascending) {
                for (int i = count() - 1; i > 0; i--) {
                    if (track.getDuration() < trackAt(i).getDuration()) {
                        super.move(i + 1, -1);
                    }
                }
            } else {
                for (int i = count() - 1; i > 0; i--) {
                    if (track.getDuration() > trackAt(i).getDuration()) {
                        super.move(i + 1, -1);
                    }
                }
            }
            return true;
        } else return false;
    }

    @Override
    public void invert() {
        ascending = !ascending;
        super.invert();
    }
}
