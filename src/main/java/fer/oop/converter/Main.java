package fer.oop.converter;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path binPath = Path.of("src/main/java/fer/oop/converter/pickle-rick-bytes.ppm");
        Path asciiPath = Path.of("src/main/java/fer/oop/converter/pickle-rick-chars.ppm");

        PPMImage binImg = new PPMImage(binPath);
        PPMImage asciiImg = new PPMImage(asciiPath);

        //binImg.resize();

        binImg.saveToAsciiFile(Path.of("src/main/java/fer/oop/converter/pickle-rick-chars2.ppm"));
        asciiImg.saveToBinaryFile(Path.of("src/main/java/fer/oop/converter/pickle-rick-bytes2.ppm"));
    }
}
