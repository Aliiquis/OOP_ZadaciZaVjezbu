package fer.oop.zzv10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class NewPointsUtil {
    public static Map<String, Integer> getForYear(int year) throws IOException {
        Path yearDirPath = Path.of(String.format("src/main/java/fer/oop/zzv10/data/%d/voting", year));
        if (!yearDirPath.toFile().exists()) return null;
        SimplestFileVisitor fileVisitor = new SimplestFileVisitor();
        Files.walkFileTree(yearDirPath, fileVisitor);
        return fileVisitor.getMap();
    }
}
