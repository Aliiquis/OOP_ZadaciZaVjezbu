package fer.oop.zzv10;

import java.io.IOException;
import java.nio.file.Path;

public class JuryPoints extends Voting {
    public JuryPoints(int year, String country, String[] votes) {
        super(year, country, votes);
    }

    @Override
    public void savePoints() throws IOException {
        Path filePath = Path.of(String.format("src/main/java/fer/oop/zzv10/data/%d/voting/%s-jury.txt", getYear(), getCountry()));
        if (!filePath.toFile().exists()) createFileIfMissing(filePath);
        writeResults(filePath);
    }
}
