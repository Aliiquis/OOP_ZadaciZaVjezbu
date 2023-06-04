package fer.oop.rekapitulacija_2.zad3;

import fer.oop.rekapitulacija_2.zad2.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Point> list = new LinkedList<>();
        list.add(new Point(5, 1));
        list.add(new Point(1, 5));
        list.add(new Point(3, -4));
        list.add(new Point(-9, 12));
        list.add(new Point(-5, -12));

        DistanceFromOrigin d = new DistanceFromOrigin();
        Comparator<Pair<? extends Number>> comp = Comparator.comparing(d).thenComparing(p -> p);
        //Uncomment when testing, fucks up the streams below for whatever reason
        //list.sort(comp);
        list.forEach(p -> System.out.printf("%.3f %s\n", d.apply(p), p));

        System.out.println();
        List<String> points = list.stream()
                .filter(new QuadrantPredicate(false, true, true, true))
                .sorted(comp.reversed())
                .map(p -> String.format("dist(%d, %d)=%.2f", p.getX(), p.getY(), d.apply(p)))
                .toList();
        points.forEach(System.out::println);

        System.out.println();
        OptionalDouble avg = list.stream()
                .filter(new QuadrantPredicate(false, true, true, true))
                .mapToDouble(d::apply)
                .average();
        avg.ifPresentOrElse(System.out::println, () -> System.out.println("oops"));
    }
}
