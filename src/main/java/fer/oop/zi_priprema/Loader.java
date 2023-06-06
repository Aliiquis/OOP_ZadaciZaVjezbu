package fer.oop.zi_priprema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.Stream;

public final class Loader {

    private Loader() {
    }

    public static <T> Stream<T> load(Path path, Function<String, ? extends T> lineMapper) throws IOException {
        return Files.lines(path).skip(1).map(lineMapper);
    }

    public static Stream<Album> loadAlbums() throws IOException {
        return load(Path.of(PathConstants.ALBUMS_RESOURCE), Album::parse);
    }

    public static Stream<Track> loadTracks() throws IOException {
        return load(Path.of(PathConstants.TRACKS_RESOURCE), Track::parse);
    }
}
