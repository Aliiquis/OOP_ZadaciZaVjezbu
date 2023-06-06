package fer.oop.zi_priprema;

import java.io.IOException;
import java.nio.file.Path;

public interface Aggregator<T> {
    void aggregate(Path path) throws IOException;

    T getResult();
}
