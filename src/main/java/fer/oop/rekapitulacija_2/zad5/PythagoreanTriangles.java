package fer.oop.rekapitulacija_2.zad5;

import fer.oop.rekapitulacija_2.zad1.Ntuple;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PythagoreanTriangles implements Iterable<Ntuple<Integer>> {
    private final Set<Ntuple<Integer>> triplets;

    public PythagoreanTriangles(int a, int b) {
        if (a < 1 || b < 1) throw new IllegalArgumentException("Invalid bounds.");
        this.triplets = new TreeSet<>();
        for (int x = 1; x < a; x++) {
            for (int y = x + 1; y < b; y++) {
                double num = Math.pow(x, 2) + Math.pow(y, 2);
                if (Math.floor(Math.sqrt(num)) == Math.ceil(Math.sqrt(num))) {
                    triplets.add(new Ntuple<>(x, y, (int) Math.sqrt(num)));
                }
            }
        }
    }

    @Override
    public Iterator<Ntuple<Integer>> iterator() {
        return triplets.iterator();
    }
}
