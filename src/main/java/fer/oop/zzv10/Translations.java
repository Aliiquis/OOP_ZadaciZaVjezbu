package fer.oop.zzv10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Translations {
    public static Map<String, Map<String, String>> load() throws IOException {
        Map<String, Map<String, String>> translationMap = new HashMap<>();
        Path translationsDir = Path.of("src/main/java/fer/oop/zzv10/data/translations");
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(translationsDir);
        for (Path path : directoryStream) {
            Map<String, String> currTranslation = new HashMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile(), StandardCharsets.UTF_8))) {
                while (true) {
                    String line = reader.readLine();
                    if (line == null) break;
                    String[] args = line.split(":");
                    currTranslation.put(args[0], args[1]);
                }
            }
            translationMap.put(path.toString().substring(path.toString().length() - 6, path.toString().length() - 4), currTranslation);
        }
        directoryStream.close();
        return translationMap;
    }

    public static String translate(String countryName, String languageCode, Map<String, Map<String, String>> translations) {
        String translation = translations.get(languageCode).get(countryName);
        return translation == null ? countryName : translation;
    }
}
