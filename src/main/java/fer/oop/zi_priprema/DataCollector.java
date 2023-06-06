package fer.oop.zi_priprema;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Predicate;

public class DataCollector {
    public static <R> R collectData(
            Path path,
            Aggregator<R> aggregator,
            Predicate<? super Path> skipDirectory,
            Predicate<? super Path> shouldProcessFile
    ) throws IOException {
        MyFileVisitor<R> fileVisitor = new MyFileVisitor<>(aggregator, skipDirectory, shouldProcessFile);
        Files.walkFileTree(path, fileVisitor);
        return fileVisitor.aggregator.getResult();
    }

    private static class MyFileVisitor<R> extends SimpleFileVisitor<Path> {
        private Aggregator<R> aggregator;
        private Predicate<? super Path> skipDirectory;
        private Predicate<? super Path> shouldProcessFile;

        public MyFileVisitor(Aggregator<R> aggregator, Predicate<? super Path> skipDirectory, Predicate<? super Path> shouldProcessFile) {
            this.aggregator = aggregator;
            this.skipDirectory = skipDirectory;
            this.shouldProcessFile = shouldProcessFile;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (!skipDirectory.test(dir)) return FileVisitResult.CONTINUE;
            else return FileVisitResult.SKIP_SUBTREE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (shouldProcessFile.test(file)) aggregator.aggregate(file);
            return FileVisitResult.CONTINUE;
        }
    }
}
