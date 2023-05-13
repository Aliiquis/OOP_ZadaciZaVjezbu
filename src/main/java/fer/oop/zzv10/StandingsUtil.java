package fer.oop.zzv10;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StandingsUtil {
    public static List<Pair<String, Integer>> orderByPoints(Map<String, Integer> map) {
        if (map == null) return null;
        List<Pair<String, Integer>> orderedPointsList = new LinkedList<>();
        for (String country : map.keySet()) {
            if (orderedPointsList.size() == 0) orderedPointsList.add(new Pair<>(country, map.get(country)));
            int temp = new LinkedList<>(orderedPointsList).size();
            for (int i = 0; i < temp; i++) {
                Pair<String, Integer> currCountry = orderedPointsList.get(i);
                if (!country.equals(currCountry.getFirst())) {
                    if (map.get(country) > currCountry.getSecond()) {
                        orderedPointsList.add(i, new Pair<>(country, map.get(country)));
                        break;
                    } else if (i == temp - 1) orderedPointsList.add(new Pair<>(country, map.get(country)));
                }
            }
        }
        return orderedPointsList;
    }
}
