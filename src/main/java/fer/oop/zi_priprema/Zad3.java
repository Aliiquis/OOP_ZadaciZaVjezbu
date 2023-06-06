package fer.oop.zi_priprema;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Zad3 implements Consumer<Scanner> {

    @Override
    public void accept(Scanner scanner) {
        System.out.println("Upisite putanju do direktorija u kojem se nalaze albumi podijeljeni na godine: ");
        String line;
        if ((line = scanner.nextLine()) == null) {
            throw new IllegalArgumentException("Ne mogu dohvatiti input od usera!");
        }
        Path dirPath = Util.ensureDirectory(Path.of(line.trim()));
        System.out.println("Upisite desetljeca po kojima zelite pretraziti (odvojeno zarezom): ");
        if ((line = scanner.nextLine()) == null) {
            throw new IllegalArgumentException("Ne mogu dohvatiti input od usera!");
        }
        Set<String> decades = new HashSet<>(Arrays.asList(line.split(",")));
        Predicate<Path> decadesPredicate = p -> !decades.contains(p.getFileName().toString()) && !p.equals(dirPath);
        Predicate<Path> albumsPredicate = p -> p.getFileName().toString().endsWith(PathConstants.ALBUMS_CSV);
        GroupingAggregator<Long, Album> albumsAggregator = new GroupingAggregator<Long, Album>(
                Album::parse,
                s -> s.collect(Collectors.toMap(Album::getId, Function.identity())));
        try {
            Map<Long, Album> albums = DataCollector.collectData(dirPath, albumsAggregator, decadesPredicate, albumsPredicate);
            Map<Long, IntSummaryStatistics> albumLengthStatistics = Loader.loadTracks()
                    .filter(track -> albums.containsKey(track.getAlbumId()))
                    .collect(Collectors.groupingBy(Track::getAlbumId,
                            Collectors.summarizingInt(Track::getTrackLength)));
            albums.entrySet().forEach(albumEntry -> {
                Long albumId = albumEntry.getKey();
                Album album = albumEntry.getValue();
                IntSummaryStatistics statistics = albumLengthStatistics.get(albumId);
                System.out.println("Album: " + album.getTitle() + " (" + album.getYear() + ")");
                System.out.println("	Number of tracks: " + statistics.getCount());
                System.out.println("	Total seconds: " + statistics.getSum());
                System.out.println("	Longest track lasts (sec): " + statistics.getMax());
                System.out.println("	Shortest track lasts (sec): " + statistics.getMin());
                System.out.println("	Average track length (sec): " + statistics.getAverage());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
