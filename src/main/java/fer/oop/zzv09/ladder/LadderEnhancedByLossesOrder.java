package fer.oop.zzv09.ladder;

import java.util.*;

public class LadderEnhancedByLossesOrder extends LadderEnhanced {

    public LadderEnhancedByLossesOrder(String... players) {
        super(players);
    }

    public Iterable<String> orderByLosses() {
        List<String> sortedNameList = new LinkedList<>();
        Map<Integer, Set<String>> map = new TreeMap<>();
        for (String name : standings()) {
            Set<String> names = map.computeIfAbsent(losses(name), k -> new HashSet<>());
            names.add(name);
        }
        for (Set<String> names : map.values()) {
            sortedNameList.addAll(names);
        }
        return sortedNameList;
    }
}
