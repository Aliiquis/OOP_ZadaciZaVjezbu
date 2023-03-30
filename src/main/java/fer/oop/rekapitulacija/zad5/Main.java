package fer.oop.rekapitulacija.zad5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        System.out.println("Unesite brojeve, za kraj unosa unesite bilo sto osim broja:");
        while (sc.hasNextInt()) {
            Integer n = sc.nextInt();
            if (!arr.contains(n)) {
                arr.add(n);
            }
        }
        for (Integer integer : arr) {
            bst.add(integer);
        }
        //note: stablo će ispisati položeno na bok
        bst.print();
    }
}
