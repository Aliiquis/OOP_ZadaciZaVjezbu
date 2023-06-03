package fer.oop.rekapitulacija_2.zad3;

import fer.oop.rekapitulacija_2.zad2.DistanceFromOrigin;
import fer.oop.rekapitulacija_2.zad2.Pair;
import fer.oop.rekapitulacija_2.zad2.Point;
import fer.oop.rekapitulacija_2.zad2.QuadrantPredicate;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Point> list = new LinkedList<>();
        list.add(new Point(5, 1));
        list.add(new Point(1, 5));
        list.add(new Point(3, -4));
        list.add(new Point(-5, -12));
        list.add(new Point(-9, 12));

        //Uncomment lines and comment others when testing streams below, fucks up the predicate

        DistanceFromOrigin d = new DistanceFromOrigin();
        Comparator<Pair<? extends Number>> comp = Comparator.comparing(d::apply).thenComparing(p -> p);
        //list.sort(comp);
        list.forEach(p -> System.out.printf("%.3f %s\n", d.apply(p), p));

        System.out.println();
        Predicate<Pair<? extends Number>> predicate = new QuadrantPredicate(false, true, true, true);
        //List<String> points = list.stream().filter(predicate).sorted(comp.reversed()).map(p -> String.format("dist(%d, %d)=%.2f", p.getX(), p.getY(), d.apply(p))).toList();
        //points.forEach(System.out::println);

        System.out.println();
        System.out.println("avg dist: " + list.stream().filter(predicate).mapToDouble(d::apply).average().getAsDouble());
    }
}
