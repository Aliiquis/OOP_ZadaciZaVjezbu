package fer.oop.zzv09.ladder;

import java.util.ArrayList;
import java.util.Collections;

public class LadderUtil {
    public static Iterable<Pair<String>> randomDraw(Ladder ladder) {
        ArrayList<Pair<String>> draw = new ArrayList<>();
        ArrayList<String> list = (ArrayList<String>) ladder.standings();
        Collections.shuffle(list);
        for (int i = 0; i <= list.size() - 2; i += 2) {
            draw.add(new Pair<>(list.get(i), list.get(i + 1)));
        }
        if (list.size() % 2 != 0) {
            draw.add(new Pair<>(list.get(list.size() - 1), "FREE"));
        }
        return draw;
    }
}
