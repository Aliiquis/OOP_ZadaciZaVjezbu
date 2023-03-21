package fer.oop.knjiznica;

public class Util {
    //statičke metode koje vraćaju polja učenika i knjiga

    public static Ucenik[] loadUcenici() {
        Ucenik[] ucenici = new Ucenik[5];
        ucenici[0] = new Ucenik("111", "Ana", "Anic", 3, 5);
        ucenici[1] = new Ucenik("222", "Ivo", "Ivic", 5, 3);
        ucenici[2] = new Ucenik("333", "Sara", "Saric", 7, 5);
        ucenici[3] = new Ucenik("444", "Marko", "Maric", 3, 5);
        ucenici[4] = new Ucenik("555", "Branko", "Brankic", 8, 3);
        return ucenici;
    }

    public static Knjiga[] loadKnjige() {
        Knjiga[] knjige = new Knjiga[10];
        knjige[0] = new Knjiga("Pavao Pavličić", "Trojica u Trnju", "1", 3);
        knjige[1] = new Knjiga("J.K. Rowling", "Harry Potter i kamen mudraca", "2", 4);
        knjige[2] = new Knjiga("Richard Bach", "Galeb Jonathan Livingstone", "3", 2);
        knjige[3] = new Knjiga("Franz Kafka", "Proces", "4", 2);
        knjige[4] = new Knjiga("George Orwell", "1984", "5", 3);
        knjige[5] = new Knjiga("Maria Gripe", "Zujak leti u sumrak", "6", 4);
        knjige[6] = new Knjiga("Douglas Adams", "Vodič kroz galaksiju za autostopere", "7", 2);
        knjige[7] = new Knjiga("Joseph Heller", "Kvaka 22", "7", 2);
        knjige[8] = new Knjiga("Terry Pratchett", "The colour of magic", "8", 0);
        knjige[9] = new Knjiga("Grigor Vitez", "Ogledalce", "9", 50);
        return knjige;
    }


}
