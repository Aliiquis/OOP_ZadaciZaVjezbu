package fer.oop.converter;

import java.io.*;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class PPMImage {
    private final Path imgPath;
    private final List<String> comments;
    private int width, height;
    private int maxColor;

    public PPMImage(Path imgPath) {
        this.imgPath = imgPath;
        this.comments = new LinkedList<>();
    }

    public void resize() {
        width /= 2;
        height /= 2;
    }

    public void saveToAsciiFile(Path destination) {
        try (BufferedReader br = new BufferedReader(new FileReader(imgPath.toFile()));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destination.toFile()));
             BufferedInputStream bis = new BufferedInputStream(new FileInputStream(imgPath.toFile()))) {

            //Reading the header
            String line = br.readLine();
            moveBinPointer(line, bis);
            while (true) {
                line = br.readLine();
                moveBinPointer(line, bis);
                if (line.charAt(0) != '#') break;
                comments.add(line);
            }
            String[] dimensions = line.split(" ");
            width = Integer.parseInt(dimensions[0]);
            height = Integer.parseInt(dimensions[1]);
            line = br.readLine();
            moveBinPointer(line, bis);
            maxColor = Integer.parseInt(line);

            //Storing the header
            bw.write("P3\n");
            for (String comment : comments) {
                bw.write(comment + "\n");
            }
            bw.write(width + " ");
            bw.write(height + "\n");
            bw.write(maxColor + "\n");

            //Reading, converting and writing bytes
            byte[] buff = new byte[15];
            while (true) {
                int n = bis.read(buff);
                if (n < 1) break;
                for (int i = 0; i < n; i++) {
                    bw.write((buff[i] & 0xFF) + " ");
                }
                bw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToBinaryFile(Path destination) {
        try (BufferedReader br = new BufferedReader(new FileReader(imgPath.toFile()));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destination.toFile()))) {

            //Reading the header
            String line;
            br.readLine();
            while (true) {
                line = br.readLine();
                if (line.charAt(0) != '#') break;
                comments.add(line);
            }
            String[] dimensions = line.split(" ");
            width = Integer.parseInt(dimensions[0]);
            height = Integer.parseInt(dimensions[1]);
            line = br.readLine();
            maxColor = Integer.parseInt(line);

            //Storing the header
            bw.write("P6\n");
            for (String comment : comments) {
                bw.write(comment + "\n");
            }
            bw.write(width + " ");
            bw.write(height + "\n");
            bw.write(maxColor + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(imgPath.toFile()));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination.toFile(), true))) {

            //Reading RGB values and converting to bytes
            int numOfHeaderLines = comments.size() + 3;
            int lineNum = 0;
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                lineNum++;
                if (lineNum <= numOfHeaderLines) continue;
                String[] values = line.split(" ");
                for (String value : values) {
                    bos.write(Integer.parseInt(value) & 0xFF);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void moveBinPointer(String line, BufferedInputStream stream) throws IOException {
        for (int i = 0; i < line.length() + 1; i++) {
            stream.read();
        }
    }
}
