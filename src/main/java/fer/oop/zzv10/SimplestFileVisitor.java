package fer.oop.zzv10;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.TreeMap;

public class SimplestFileVisitor extends SimpleFileVisitor<Path> {
    private Map<String, Integer> map = new TreeMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith("-jury.txt") || file.toString().endsWith("-televoting.txt")) {
            PointsUtil.update(file, map);
        }
        return FileVisitResult.CONTINUE;
    }

    public Map<String, Integer> getMap() {
        return map;
    }
}
