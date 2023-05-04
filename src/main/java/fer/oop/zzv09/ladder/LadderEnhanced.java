package fer.oop.zzv09.ladder;

import java.util.HashMap;
import java.util.Map;

public class LadderEnhanced extends Ladder {
    private Map<String, Stats> enhancedLadder = new HashMap<>();

    public LadderEnhanced(String... players) {
        super(players);
    }

    @Override
    public void gameFinished(String winner, String loser) {
        Stats stat = enhancedLadder.get(winner);
        if (stat == null) {
            stat = new Stats();
            enhancedLadder.put(winner, stat);
        }
        stat.won();

        stat = enhancedLadder.get(loser);
        if (stat == null) {
            stat = new Stats();
            enhancedLadder.put(loser, stat);
        }
        stat.lost();

        super.gameFinished(winner, loser);
    }

    public int wins(String player) {
        return enhancedLadder.containsKey(player) ? enhancedLadder.get(player).getWins() : 0;
    }

    public int losses(String player) {
        return enhancedLadder.containsKey(player) ? enhancedLadder.get(player).getLosses() : 0;
    }
}
