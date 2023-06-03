package fer.oop.rekapitulacija_2.zad5;

import fer.oop.rekapitulacija_2.zad1.Ntuple;

public class Main {
    public static void main(String[] args) {
        PythagoreanTriangles triples = new PythagoreanTriangles(50, 80);
        for (Ntuple<Integer> p : triples)
            System.out.println(p);
    }
}
