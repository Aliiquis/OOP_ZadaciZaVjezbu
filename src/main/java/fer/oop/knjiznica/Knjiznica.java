package fer.oop.knjiznica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Knjiznica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ucenik[] ucenici = Util.loadUcenici();
        Knjiga[] knjige = Util.loadKnjige();
        List<Posudba> posudbe = new ArrayList<>();
        int izbor;
        do {
            System.out.println(
                    """
                            1. Posudba
                            2. Vracanje
                            3. Pregled svih ucenika
                            4. Pregled svih knjiga
                            5. Pregled aktivnih posudbi
                            6. Pregled svih posudbi
                            7. Kraj
                            IZBOR:""");
            izbor = sc.nextInt();
            switch (izbor) {
                case 1 -> {
                    sc.nextLine();
                    System.out.print("Upisite OIB: ");
                    String OIB = sc.nextLine();
                    for (Ucenik ucenik : ucenici) {
                        if (OIB.equals(ucenik.getOIB())) {
                            System.out.print("Broj knjiga: ");
                            int brKnjiga = sc.nextInt();
                            while (brKnjiga > ucenik.getMaxPosudba()) {
                                System.out.print("Ucenik moze posuditi najvise " + ucenik.getMaxPosudba() + " knjige!\n" +
                                        "Broj knjiga: ");
                                brKnjiga = sc.nextInt();
                            }
                            sc.nextLine();
                            Knjiga[] posudeneKnjige = new Knjiga[brKnjiga];
                            String ISBN;
                            for (int i = 0; i < brKnjiga; i++) {
                                System.out.print("ISBN " + (i + 1) + ". knjige: ");
                                ISBN = sc.nextLine();
                                for (Knjiga knjiga : knjige) {
                                    if (knjiga.getISBN().equals(ISBN)) {
                                        if (knjiga.getBrojPrimjeraka() <= 0) {
                                            System.out.println("Svi primjerci knjige s tim ISBN-om su posudjeni!");
                                            i--;
                                        } else {
                                            posudeneKnjige[i] = knjiga;
                                        }
                                    }
                                }
                            }
                            posudbe.add(new Posudba(ucenik, posudeneKnjige, LocalDate.now(), true));
                        }
                    }
                }
                case 2 -> {
                    sc.nextLine();
                    boolean vraceno = false;
                    do {
                        System.out.print("Upisite OIB: ");
                        String OIB = sc.nextLine();
                        boolean pronaden = false;
                        for (Ucenik ucenik : ucenici) {
                            if (OIB.equals(ucenik.getOIB())) {
                                pronaden = true;
                                for (Posudba posudba : posudbe) {
                                    if (posudba.getUcenik().getOIB().equals(OIB)) {
                                        if (posudba.isAktivna()) {
                                            posudba.setAktivna(false);
                                            vraceno = true;
                                            System.out.println("Uspjesno je vraceno " + posudba.getKnjige().length + " knjiga.");
                                        } else {
                                            System.out.println("Ne postoji aktivna posudba za ovog ucenika.");
                                        }
                                    }
                                }
                            }
                        }
                        if (!pronaden) {
                            System.out.println("Ne postoji ucenik s tim OIB-om.");
                        }
                    } while (!vraceno);
                }
                case 3 -> {
                    for (Ucenik ucenik : ucenici) {
                        System.out.println(ucenik);
                    }
                }
                case 4 -> {
                    for (Knjiga knjiga : knjige) {
                        System.out.println(knjiga);
                    }
                }
                case 5 -> {
                    for (Posudba posudba : posudbe) {
                        if (posudba.isAktivna()) {
                            System.out.println(posudba);
                        }
                    }
                }
                case 6 -> {
                    for (Posudba posudba : posudbe) {
                        System.out.println(posudba);
                    }
                }
                case 7 -> {
                }
                default -> System.out.println("Krivi unos");
            }
        } while (izbor != 7);
    }
}
