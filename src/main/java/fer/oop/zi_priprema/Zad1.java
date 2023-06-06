package fer.oop.zi_priprema;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Zad1 implements Consumer<Scanner> {

    @Override
    public void accept(Scanner t) {
        try {
            Loader.loadAlbums()
                    .collect(Collectors.groupingBy(a -> a.getYear() / 10 * 10))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue().size()))
                    .forEach(e -> System.out.println(e.getKey() + "=" + e.getValue()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
