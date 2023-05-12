package fer.oop.zzv10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TelevotingPoints {
    private int year;
    private String televotingCountry;
    private String[] votes;

    public TelevotingPoints(int year, String televotingCountry, String[] votes) {
        this.year = year;
        this.televotingCountry = televotingCountry;
        this.votes = votes;
    }

    public int getYear() {
        return year;
    }

    public String getTelevotingCountry() {
        return televotingCountry;
    }

    public String[] getVotes() {
        return votes;
    }

    public void savePoints() {
        final int[] points = new int[]{12, 10, 8, 7, 6, 5, 4, 3, 2, 1};
        Path filePath = Path.of(String.format("src/main/java/fer/oop/zzv10/data/%d/voting/%s-televoting.txt", year, televotingCountry));
        if (!filePath.toFile().exists()) {
            try {
                Files.createDirectories(filePath.getParent());
                Files.createFile(filePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile(), StandardCharsets.UTF_8))) {
            for (int i = 0; i < 10; i++) {
                writer.write(String.format("%2d %s\n", points[i], votes[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
