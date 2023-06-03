package fer.oop.rekapitulacija_2.zad4;

import fer.oop.rekapitulacija_2.zad2.DistanceFromOrigin;
import fer.oop.rekapitulacija_2.zad2.Point;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Point> list = new LinkedList<>();
        list.add(new Point(5, 1));
        list.add(new Point(1, 5));
        list.add(new Point(10, 50));
        list.add(new Point(3, -4));
        list.add(new Point(-5, -12));
        list.add(new Point(-9, 12));

        DistanceFromOrigin d = new DistanceFromOrigin();

        Map<Integer, Set<Point>> map = new TreeMap<>();
        for (Point p : list) {
            int x = p.getX();
            int y = p.getY();
            int quadrant = 0;

            if (x > 0 && y > 0) quadrant = 1;
            else if (x < 0 && y > 0) quadrant = 2;
            else if (x < 0 && y < 0) quadrant = 3;
            else if (x > 0 && y < 0) quadrant = 4;

            if (quadrant > 0) {
                map.computeIfAbsent(quadrant, k -> new TreeSet<>(Comparator.comparing(d::apply)));
                Set<Point> set = map.get(quadrant);
                set.add(p);
                map.put(quadrant, set);
            }
        }

        for (Map.Entry<Integer, Set<Point>> entry : map.entrySet()) {
            System.out.println("Quadrant " + entry.getKey() + ":");
            entry.getValue().forEach(System.out::println);
        }
    }
}
