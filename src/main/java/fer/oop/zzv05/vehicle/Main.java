package fer.oop.zzv05.vehicle;

public class Main {
    public static void main(String[] args) {
        System.out.println("7. ---------------------------");
        Vehicle car = new Car("DA8818BB", "Renault Megane Grandtour", "caravan", 4, 800);
        PassengerVan van3 = new PassengerVan("DA6282EA", "IMV 1600", 212, 8);
        Limo limo = new Limo("DA2238AB", "Zastava 750 LE", 320, 4, false);
        LoadPassengers[] loadPassengers = new LoadPassengers[]{limo, (LoadPassengers) car, van3};
        for (LoadPassengers lp : loadPassengers) {
            System.out.println(lp);
            if (lp instanceof LoadCargo) {
                System.out.println(" - this passenger vehicle can also transport cargo!");
                System.out.println(" max cargo space: " + ((LoadCargo) lp).getMaxSpace());
            }
        }
    }
}
