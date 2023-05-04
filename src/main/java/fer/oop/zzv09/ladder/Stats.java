package fer.oop.zzv09.ladder;

public class Stats {
    private int wins;
    private int losses;

    public Stats() {
        this.wins = 0;
        this.losses = 0;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public void won() {
        wins++;
    }

    public void lost() {
        losses++;
    }
}
