package fer.oop.zzv04;

public class Main {
    public static void main(String[] args) {
        System.out.println("2. ------------------------------------------");
        Dessert cake = new Cake("Sacher Torte", 3., 1000, true, "birthday");
        System.out.println(cake);
        Dessert icecream = new IceCream("Chocolate chip", .25, 300, "chocolate chip", "beige");
        System.out.println(icecream);
        System.out.println("5. ------------------------------------------");
        final Person[] personArr = new Person[]{
                new Teacher("Jesus", "Christ", 34, "godisgreat@gmail.com", "theology", 1000.),
                new Teacher("Dwayne", "Johnson", 50, "wweraw@yahoo.com", "PE", 2000.),
                new Teacher("Marko", "Čupić", 40, "jedanmalimuxic@gmail.com", "digital logic", 3000.),
                new Student("Mali", "Ivica", 19, "buricislife", (short) 3),
                new Student("Veliki", "Ivica", 37, "ihateburic", (short) 19)
        };
        double salarySum = 0;
        int numOfTeachers = 0;
        for (Person p : personArr) {
            System.out.println(p.getName() + ' ' + p.getSurname());
            if (p instanceof Teacher) {
                salarySum += ((Teacher) p).getSalary();
                numOfTeachers++;
            }
        }
        System.out.println("Average teacher salary: " + salarySum / numOfTeachers);
        Person p1 = new Person("Ivo", "Ivic", 20);
        Person p2 = new Person("Ivo", "Ivic", 20);
        Person p3 = new Student("Ivo", "Ivic", 20, "0036312123", (short) 3);
        Person p4 = new Student("Marko", "Marić", 25, "0036312123", (short) 5);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
        System.out.println(p3.equals(p4));
        System.out.println("7. ------------------------------------------");
        Dessert genericDessert = new Dessert("Chocolate Mousse", 120, 300);
        Cake cake2 = new Cake("Raspberry chocolate cake #3", 350.5, 400, false, "birthday");
        Teacher t1 = new Teacher("Dario", "Tušek", 42, "dario.tusek@fer.hr", "OOP", 10000);
        Teacher t2 = new Teacher("Doris", "Bezmalinović", 43, "doris.bezmalinovic@fer.hr", "OOP", 10000);
        Student s1 = new Student("Janko", "Horvat", 18, "0036312123", (short) 1);
        Student s2 = new Student("Ana", "Kovać", 19, "0036387656", (short) 2);
        Student s3 = new Student("Ivana", "Stanić", 19, "0036392357", (short) 1);
        UniMasterChef competition = new UniMasterChef(2);
        CompetitionEntry e1 = new CompetitionEntry(t1, genericDessert);
        competition.addEntry(e1);
        System.out.println("Entry 1 rating: " + e1.getRating());
        e1.addRating(s1, 4);
        e1.addRating(s2, 5);
        System.out.println("Entry 1 rating: " + e1.getRating());
        CompetitionEntry e2 = new CompetitionEntry(t2, cake2);
        e2.addRating(s1, 4);
        e2.addRating(s3, 5);
        e2.addRating(s2, 5);
        competition.addEntry(e2);
        System.out.println("Entry 2 rating: " + e2.getRating());
        System.out.println("Best dessert is: " + competition.getBestDessert().getName());
        Person[] e2persons = UniMasterChef.getInvolvedPeople(e2);
        for (Person p : e2persons)
            System.out.println(p);
        System.out.println("10. ------------------------------------------");
        Vehicle v = new Car("DA1234AA", "Renault Clio", 2001, 20, "coupe", 200);
        Car car = new Car("DA8818BB", "Renault Megane Grandtour", 2007, 25, "caravan", 800);
        Van van1 = new CargoVan("DA0009PO", "Volkswagen Transporter", 2018, 28, 2, (short) 3, 4500);
        PassengerVan van2 = new PassengerVan("DA6282EA", "IMV 1600", 1978, 35, 2, (short) 3, 0);
        Vehicle limo = new Limo("DA2238AB", "Zastava 750 LE", 1983, 220, 3.2, false, false);
        System.out.println(v.getModel() + " price per day: " + v.getPricePerDay());
        System.out.println(van1.getModel() + " price per day: " + van1.getPricePerDay());
        System.out.println(van2.getModel() + " price per month: " + van2.getPricePerMonth());
        Vehicle newest = Vehicle.getNewestVehicle(v, car, van1, van2, limo);
        System.out.println("Newest: " + newest.getModel() + ", " + newest.getYear());
        Vehicle.printAllVehiclesWithCargoSpaceGreaterThan(500, v, car, van1, van2, limo);
    }
}
