package fer.oop.zzv10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class DownloadFlags {
    public static void download() throws IOException {
        Path dataPath = Path.of("src/main/java/fer/oop/zzv10/data");
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dataPath);
        for (Path path : directoryStream) {
            Path subDirs = Path.of(String.format("%s/voting", path));
            if (Files.exists(subDirs) && Files.size(subDirs) > 0) {
                Path downloadDir = Path.of(String.format("%s/flags", path));
                Files.createDirectories(downloadDir);
                Map<String, Integer> standings = PointsUtil.getForYear(Integer.parseInt(path.toString().substring(path.toString().length() - 4)));
                for (String country : standings.keySet()) {
                    URL url = new URL(String.format("https://cdn.countryflags.com/thumbs/%s/flag-400.png", country.replace(' ', '-').toLowerCase()));
                    try (BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream())) {
                        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(String.format("%s/%s.png", downloadDir, country)))) {
                            byte[] buffer = new byte[1024];
                            int read;
                            while ((read = bufferedInputStream.read(buffer, 0, 1024)) != -1) {
                                bufferedOutputStream.write(buffer, 0, read);
                            }
                        }
                    }
                }
            }
        }
        directoryStream.close();
    }
}
