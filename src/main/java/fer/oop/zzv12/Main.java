package fer.oop.zzv12;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Apartment apartment = new Apartment("Unska 2, 10000 Zagreb", 2);
        Room kitchen = new Room(FloorType.CERAMIC, BigDecimal.valueOf(8.56), false, 1,
                Color.YELLOW);
        Room bathRoom = new BathRoom(true, 1, "shower", FloorType.CERAMIC, BigDecimal.valueOf(7.28), true, 0, Color.BLUE);//changed line
        Room bedRoom1 = new Room(FloorType.HARDWOOD, BigDecimal.valueOf(12.23), true, 1,
                Color.PINK);
        Room bedRoom2 = new Room(FloorType.HARDWOOD, BigDecimal.valueOf(17.33), true, 2,
                Color.GREEN);
        Room livingRoom = new Room(FloorType.HARDWOOD, BigDecimal.valueOf(20.08), true, 3,
                Color.ORANGE);
        apartment.addRooms(kitchen, bathRoom, bedRoom1, bedRoom2,
                livingRoom);
        System.out.println("Added room found: " +
                apartment.containsRoom(bedRoom2));
        System.out.println("Identical room found: " +
                apartment.containsRoom(new Room(FloorType.HARDWOOD, BigDecimal.valueOf(17.33), true, 2,
                        Color.GREEN)));
        System.out.println("Almost identical room found: " +
                apartment.containsRoom(new Room(FloorType.HARDWOOD, BigDecimal.valueOf(18.01).subtract(BigDecimal.valueOf(0.68)), true, 2,
                        Color.GREEN)));
        System.out.println("Same bathroom: " + apartment.containsRoom(new BathRoom(true, 1, "shower",
                FloorType.CERAMIC, BigDecimal.valueOf(7.28), true, 0, Color.BLUE)));
        System.out.println("Different bathroom: " + apartment.containsRoom(new BathRoom(false, 2, "bath",
                FloorType.CERAMIC, BigDecimal.valueOf(7.28), true, 0, Color.BLUE)));
        apartment.getRooms().forEach(room -> System.out.println(room.getNumberOfWindows() + " " + room.getFloorType()));
        System.out.println("Number of rooms: " + apartment.getRooms().size());
        Apartment[] apartments = ApartmentLoader.load();
        List<Apartment> listOfApartments = Arrays.asList(apartments);
        System.out.println("Added apartment found: " +
                listOfApartments.contains(apartments[2]));
        System.out.println("Identical apartment found: " +
                listOfApartments.contains(apartment));
        System.out.println("Are these apartments identical? " +
                apartments[0].equals(apartment));

        Set<Apartment> sorted = new TreeSet<>(Apartment.numOfRoomsComp.reversed()
                .thenComparing(Apartment.floorComp)
                .thenComparing(Apartment.areaComp.reversed()));
        sorted.addAll(listOfApartments);
        sorted.forEach(a -> System.out.println(a.getRooms().size() + " " + a.getFloor() + " " + a.getArea()));
    }
}
