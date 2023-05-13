package fer.oop.zzv10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class Voting {
    private final int year;
    private final String country;
    private final String[] votes;
    private final int[] points = new int[]{12, 10, 8, 7, 6, 5, 4, 3, 2, 1};

    public Voting(int year, String country, String[] votes) {
        this.year = year;
        this.country = country;
        this.votes = votes;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String[] getVotes() {
        return votes;
    }

    public void createFileIfMissing(Path filePath) {
        try {
            Files.createDirectories(filePath.getParent());
            Files.createFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeResults(Path filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile(), StandardCharsets.UTF_8))) {
            for (int i = 0; i < 10; i++) {
                writer.write(String.format("%2d %s\n", points[i], getVotes()[i]));
            }
        }
    }

    public abstract void savePoints() throws IOException;
}
