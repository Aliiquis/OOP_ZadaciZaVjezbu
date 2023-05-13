package fer.oop.zzv10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class PointsUtil {
    public static Map<String, Integer> getForYear(int year) throws IOException {
        Path yearDirPath = Path.of(String.format("src/main/java/fer/oop/zzv10/data/%d/voting", year));
        if (!yearDirPath.toFile().exists()) return null;
        Map<String, Integer> pointsMap = new TreeMap<>();
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(yearDirPath, new VotingFilter());
        for (Path path : directoryStream) {
            update(path, pointsMap);
        }
        directoryStream.close();
        return pointsMap;
    }

    public static void update(Path path, Map<String, Integer> map) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile(), StandardCharsets.UTF_8))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                int points = Integer.parseInt(line.substring(0, 2).trim());
                String country = line.substring(3);
                //If the value at the specified key is missing fill it with points, otherwise add the new points to the existing sum.
                map.compute(country, (k, v) -> v == null ? points : v + points);
            }
        }
    }
}
