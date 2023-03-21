package fer.oop.knjiznica;

public class Knjiga {
    private String naslov;
    private String autor;
    private String ISBN;
    private int brojPrimjeraka;

    public Knjiga(String naslov, String autor, String ISBN, int brojPrimjeraka) {
        this.naslov = naslov;
        this.autor = autor;
        this.ISBN = ISBN;
        this.brojPrimjeraka = brojPrimjeraka;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getBrojPrimjeraka() {
        return brojPrimjeraka;
    }

    public void setBrojPrimjeraka(int brojPrimjeraka) {
        this.brojPrimjeraka = brojPrimjeraka;
    }

    @Override
    public String toString() {
        return "Knjiga{" +
                "naslov='" + naslov + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", brojPrimjeraka=" + brojPrimjeraka +
                '}';
    }
}
