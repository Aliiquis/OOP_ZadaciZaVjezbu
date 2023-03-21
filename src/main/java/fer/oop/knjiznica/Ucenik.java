package fer.oop.knjiznica;

public class Ucenik {
    private String ime;
    private String prezime;
    private String OIB;
    private int razred;
    private int maxPosudba;

    public Ucenik(String OIB, String ime, String prezime, int razred, int maxPosudba) {
        this.ime = ime;
        this.prezime = prezime;
        this.OIB = OIB;
        this.razred = razred;
        this.maxPosudba = maxPosudba;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getOIB() {
        return OIB;
    }

    public void setOIB(String OIB) {
        this.OIB = OIB;
    }

    public int getRazred() {
        return razred;
    }

    public void setRazred(int razred) {
        this.razred = razred;
    }

    public int getMaxPosudba() {
        return maxPosudba;
    }

    public void setMaxPosudba(int maxPosudba) {
        this.maxPosudba = maxPosudba;
    }

    @Override
    public String toString() {
        return "Ucenik{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", OIB='" + OIB + '\'' +
                ", razred=" + razred +
                ", maxPosudba=" + maxPosudba +
                '}';
    }
}
