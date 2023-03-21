package fer.oop.knjiznica;

import java.time.LocalDate;
import java.util.Arrays;

public class Posudba {
    private Ucenik ucenik;
    private Knjiga[] knjige;
    static private int rBr = 0;
    private LocalDate vrijemePosudbe;
    private boolean aktivna;

    public Posudba(Ucenik ucenik, Knjiga[] knjige, LocalDate vrijemePosudbe, boolean aktivna) {
        this.ucenik = ucenik;
        this.knjige = knjige;
        this.vrijemePosudbe = vrijemePosudbe;
        this.aktivna = aktivna;
        rBr++;
    }

    public Ucenik getUcenik() {
        return ucenik;
    }

    public void setUcenik(Ucenik ucenik) {
        this.ucenik = ucenik;
    }

    public Knjiga[] getKnjige() {
        return knjige;
    }

    public void setKnjige(Knjiga[] knjige) {
        this.knjige = knjige;
    }

    public static int getrBr() {
        return rBr;
    }

    public static void setrBr(int rBr) {
        Posudba.rBr = rBr;
    }

    public LocalDate getVrijemePosudbe() {
        return vrijemePosudbe;
    }

    public void setVrijemePosudbe(LocalDate vrijemePosudbe) {
        this.vrijemePosudbe = vrijemePosudbe;
    }

    public boolean isAktivna() {
        return aktivna;
    }

    public void setAktivna(boolean aktivna) {
        this.aktivna = aktivna;
    }

    @Override
    public String toString() {
        return "Posudba{" +
                " knjige=" + Arrays.toString(knjige) +
                ", vrijemePosudbe=" + vrijemePosudbe +
                ", aktivna=" + aktivna +
                '}';
    }
}
