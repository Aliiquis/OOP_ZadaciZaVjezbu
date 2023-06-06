package fer.oop.zi_priprema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class GroupingAggregator<K, T> implements Aggregator<Map<K, T>> {
    private Function<String, ? extends T> mapper;
    private Function<Stream<? extends T>, Map<K, T>> grouper;
    private Map<K, T> map;

    public GroupingAggregator(Function<String, ? extends T> mapper, Function<Stream<? extends T>, Map<K, T>> grouper) {
        this.mapper = mapper;
        this.grouper = grouper;
        this.map = new HashMap<>();
    }

    @Override
    public void aggregate(Path path) throws IOException {
        map.putAll(grouper.apply(Files.lines(path).map(mapper)));
    }

    @Override
    public Map<K, T> getResult() {
        return map;
    }
}
