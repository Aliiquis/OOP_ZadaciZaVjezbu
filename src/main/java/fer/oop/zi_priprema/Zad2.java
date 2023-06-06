package fer.oop.zi_priprema;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Zad2 implements Consumer<Scanner> {

    @Override
    public void accept(Scanner scanner) {
        System.out.println("Upisite putanju do direktorija u kojem ce se kreirati podjela na godine: ");
        String line;
        if ((line = scanner.nextLine()) == null) {
            throw new IllegalArgumentException("Ne mogu dohvatiti input od usera!");
        }
        Path dirPath = Util.ensureDirectory(Path.of(line.trim()));
        File dat = new File(dirPath + "/album_decades.dat");

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(dat))) {
            Loader.loadAlbums()
                    .collect(Collectors.groupingBy(a -> String.valueOf(a.getYear() / 10 * 10)))
                    .forEach((key, value) -> {
                        Path temp = Path.of(dirPath + "/" + key);
                        Util.ensureDirectory(temp);
                        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(temp + "/albums.csv"))) {
                            value.forEach(a -> {
                                try {
                                    bw.write(String.format("%d;%s;%d;%d\n", a.getId(), a.getTitle(), a.getYear(), a.getArtistId()));
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

            long count = Loader.loadAlbums().count();
            dos.writeInt((int) count);

            Loader.loadAlbums().forEach(a -> {
                try {
                    dos.writeInt((int) a.getId());
                    dos.writeInt(a.getYear() / 10 * 10);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
