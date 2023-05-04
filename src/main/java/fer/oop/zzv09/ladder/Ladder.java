package fer.oop.zzv09.ladder;

import java.util.*;

public class Ladder {
    private ArrayList<String> playerList;

    public Ladder(String... players) {
        this.playerList = new ArrayList<>();
        join(players);
    }

    public void join(String... players) {
        for (String player : players) {
            if (!playerList.contains(player)) {
                playerList.add(player);
            }
        }
    }

    public int count() {
        return playerList.size();
    }

    public Iterable<String> standings() {
        return playerList;
    }

    public void gameFinished(String winner, String loser) {
        int winnerIndex = playerList.indexOf(winner);
        int loserIndex = playerList.indexOf(loser);
        if (loserIndex < playerList.size() - 1) {
            playerList.remove(loser);
            playerList.add(loserIndex + 1, loser);
        }
        if (winnerIndex < loserIndex && winnerIndex != 0) {
            playerList.remove(winner);
            playerList.add(winnerIndex - 1, winner);
        } else if (winnerIndex != 0) {
            playerList.remove(winner);
            playerList.add(winnerIndex - ((winnerIndex - loserIndex) / 2), winner);
        }
    }
}
