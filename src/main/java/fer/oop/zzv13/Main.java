package fer.oop.zzv13;

/*import jxl.Workbook;
import jxl.read.biff.BiffException;*/

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.zip.ZipFile;

public class Main {
    /*public static void main(String[] args) {
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

            System.out.println("--------------- 6. ----------------");
            pr.getMayorResults().entrySet().stream()
                    .map((e -> new SimpleEntry<>(e.getKey(), e.getValue().get("TOMISLAV TOMAŠEVIĆ"))))
                    .sorted(Comparator.comparing(Entry<PollingStation, Integer>::getValue).reversed())
                    .limit(10)
                    .forEach(e -> System.out.println(e.getKey().getId()));

            System.out.println("--------------- 7. ----------------");
            pr.getMayorResults().entrySet().stream()
                    .flatMap(e -> {
                        int sum = e.getValue().values().stream().mapToInt(Integer::intValue).sum();
                        return e.getValue().entrySet().stream().map(c -> new SimpleEntry<>(c.getKey(), (double) c.getValue() / sum));
                    })
                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue, Double::max))
                    .forEach((k, v) -> System.out.printf("%s: %.2f%%\n", k, v * 100));

            System.out.println("--------------- 8. ----------------");
            getCandidateVotes(pr.getMayorResults()).forEach((k, v) -> System.out.println(k + " " + v));

            System.out.println("--------------- 9. ----------------");
            getCandidateVotes(pr.getMayorResults()).entrySet().stream()
                    .sorted(Comparator.comparing(Entry<String, Integer>::getValue).reversed())
                    .toList()
                    .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

            System.out.println("--------------- 10. ----------------");
            int totalVotes = pr.getMayorResults().values().stream()
                    .mapToInt(e -> e.values().stream().mapToInt(Integer::intValue).sum())
                    .sum();
            getCandidateVotes(pr.getMayorResults()).entrySet().stream()
                    .forEach(e -> System.out.printf("%s: %.2f%%\n", e.getKey(), (double) e.getValue() * 100 / totalVotes));

            System.out.println("--------------- 12. ----------------");
            getTitlesSortedPerVotes(pr.getMayorResults()).forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> getCandidateVotes(Map<PollingStation, Map<String, Integer>> results) {
        Map<String, Integer> map = new LinkedHashMap<>();
        results.values().forEach(e -> e.forEach((k, v) -> map.merge(k, v, Integer::sum)));
        return map;
    }

    public static List<Entry<String, Integer>> getTitlesSortedPerVotes(Map<PollingStation, Map<String, Integer>> results) {
        return results.entrySet().stream()
                .map(e -> new SimpleEntry<>(e.getKey().getTitle(), e.getValue().values().stream().mapToInt(Integer::intValue).sum()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Entry<String, Integer>::getValue).reversed())
                .toList();
    }*/
}
