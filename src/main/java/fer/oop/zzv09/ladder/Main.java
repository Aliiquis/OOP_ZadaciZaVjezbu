package fer.oop.zzv09.ladder;

public class Main {
    public static void main(String[] args) {
        Ladder ladder = new Ladder("Brian", "Mia", "Sophia", "John");
        ladder.join("Charlotte", "Pierre", "Bruno");
        print(ladder.standings());

        ladder.gameFinished("Mia", "John");
        System.out.println("Mia won John");
        print(ladder.standings());

        ladder.gameFinished("Bruno", "Brian");
        System.out.println("Bruno won Brian");
        print(ladder.standings());

        ladder.gameFinished("Charlotte", "Brian");
        System.out.println("Charlotte won Brian");
        print(ladder.standings());

        ladder.gameFinished("Mia", "John");
        System.out.println("Mia won John");
        print(ladder.standings());

        ladder.gameFinished("Sophia", "John");
        System.out.println("Sophia won John");
        print(ladder.standings());

        printDraw(LadderUtil.randomDraw(ladder));
        System.out.println();
        printDraw(LadderUtil.randomDraw(ladder));
        System.out.println();
        printDraw(LadderUtil.randomDraw(ladder));

        System.out.println();
        LadderEnhanced ladderEnhanced = new LadderEnhanced("Brian", "Mia", "Sophia", "John", "Charlotte", "Pierre", "Bruno");
        ladderEnhanced.gameFinished("Mia", "John");
        ladderEnhanced.gameFinished("Bruno", "Brian");
        ladderEnhanced.gameFinished("Charlotte", "Brian");
        ladderEnhanced.gameFinished("Mia", "John");
        ladderEnhanced.gameFinished("Sophia", "John");
        printStandings(ladderEnhanced);

        System.out.println();
        LadderEnhancedByLossesOrder ladderEnhancedByLossesOrder = new LadderEnhancedByLossesOrder("Brian", "Mia", "Sophia", "John", "Charlotte", "Pierre", "Bruno");
        ladderEnhancedByLossesOrder.gameFinished("Mia", "John");
        ladderEnhancedByLossesOrder.gameFinished("Bruno", "Brian");
        ladderEnhancedByLossesOrder.gameFinished("Charlotte", "Brian");
        ladderEnhancedByLossesOrder.gameFinished("Mia", "John");
        ladderEnhancedByLossesOrder.gameFinished("Sophia", "John");
        printStandings(ladderEnhancedByLossesOrder);
        printByLosses(ladderEnhancedByLossesOrder);
    }

    private static void print(Iterable<String> standings) {
        int pos = 0;
        for (String player : standings) {
            System.out.format("%d. %s%n", ++pos, player);
        }
        System.out.println();

    }

    private static void printDraw(Iterable<Pair<String>> randomDraw) {
        for (Pair<String> pair : randomDraw) {
            System.out.format("%s - %s%n", pair.getFirst(), pair.getSecond());
        }
    }

    private static void printStandings(LadderEnhanced ladder) {
        int pos = 0;
        for (String player : ladder.standings()) {
            System.out.format("%d. %s has %d wins and %d losses %n", ++pos, player,
                    ladder.wins(player), ladder.losses(player));
        }
        System.out.println();
    }

    private static void printByLosses(LadderEnhancedByLossesOrder ladder) {
        int pos = 0;
        for (String player : ladder.orderByLosses()) {
            System.out.format("%d. %s has %d losses %n", ++pos, player, ladder.losses(player));
        }
        System.out.println();
    }
}
