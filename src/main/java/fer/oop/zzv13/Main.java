package fer.oop.zzv13;

import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.net.URL;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.zip.ZipFile;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/java/fer/oop/zzv13/ZUP_21.zip");
        try (BufferedInputStream is = new BufferedInputStream(new URL("https://gitlab.tel.fer.hr/ZUP_21.zip").openStream());
             BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(file))) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = is.read(buffer)) > 0) {
                os.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ZipFile zip = null;
        try {
            zip = new ZipFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedInputStream is = new BufferedInputStream(zip.getInputStream(zip.stream().findFirst().get()))) {

            Workbook wb = Workbook.getWorkbook(is);
            PollingResults pr = new PollingResults(wb);
            
            pr.getMayorResults().entrySet().stream()
                    .map((e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue().get("TOMISLAV TOMAŠEVIĆ"))))
                    .sorted(Comparator.comparing(Map.Entry<PollingStation, Integer>::getValue).reversed())
                    .limit(10)
                    .forEach(e -> System.out.println(e.getKey().getId()));

        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
    }
}
