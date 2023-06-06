package fer.oop.zi_priprema;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

    private static final int NO_TASK = -1;

    public static Map<Integer, Consumer<Scanner>> dohvatiZadatke() {
        return new TreeMap<>(
                Map.of(
                        1, new Zad1(),
                        2, new Zad2(),
                        3, new Zad3())
        );
    }

    public static void main(String[] args) {
        Map<Integer, Consumer<Scanner>> zadaci = dohvatiZadatke();
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("Upisite koji zadatak zelite da se izvrsi, moguci zadaci: " + zadaci.keySet().stream().map(z -> String.valueOf(z)).collect(Collectors.joining("/")));
                String nextLine = scanner.nextLine();
                int taskId = Util.parseOrDefault(nextLine, NO_TASK);
                Consumer<Scanner> task = zadaci.get(taskId);
                if (task == null) {
                    break;
                }
                task.accept(scanner);
                System.out.println("ZADATAK " + task + " IZVRSEN!");
            } while (true);
        }
        System.out.println("GOTOVO!");
    }
}
