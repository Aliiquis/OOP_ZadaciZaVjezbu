package fer.oop.zzv10;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JuryPoints {
    private int year;
    private String juryCountry;
    private String[] votes;

    public JuryPoints(int year, String juryCountry, String[] votes) {
        if (votes.length != 10) throw new IllegalArgumentException("Wrong number of countries!");
        this.year = year;
        this.juryCountry = juryCountry;
        this.votes = votes;
    }

    public int getYear() {
        return year;
    }

    public String getJuryCountry() {
        return juryCountry;
    }

    public String[] getVotes() {
        return votes;
    }

    public void savePoints() {
        final int[] points = new int[]{12, 10, 8, 7, 6, 5, 4, 3, 2, 1};
        Path filePath = Path.of(String.format("src/main/java/fer/oop/zzv10/data/%d/voting/%s-jury.txt", year, juryCountry));
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
