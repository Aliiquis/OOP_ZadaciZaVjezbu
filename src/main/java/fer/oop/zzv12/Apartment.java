package fer.oop.zzv12;

import java.math.BigDecimal;
import java.util.*;

public class Apartment {
    private final Collection<Room> rooms;
    private final String address;
    private final int floor;

    public Apartment(String address, int floor) {
        this.rooms = new TreeSet<>();
        this.address = address;
        this.floor = floor;
    }

    public void addRooms(Room... rooms) {
        this.rooms.addAll(Arrays.asList(rooms));
    }

    public void removeRooms(Room... rooms) {
        for (Room room : rooms) {
            this.rooms.remove(room);
        }
    }

    public boolean containsRoom(Room room) {
        return rooms.contains(room);
    }

    public Iterator<Room> roomIterator() {
        return rooms.iterator();
    }

    public BigDecimal getArea() {
        BigDecimal area = BigDecimal.valueOf(0);
        for (Room room : rooms) {
            area = area.add(room.getArea());
        }
        return area;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public String getAddress() {
        return address;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return floor == apartment.floor && Objects.equals(rooms, apartment.rooms) && Objects.equals(address, apartment.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rooms, address, floor);
    }

    public static Comparator<Apartment> addressComp = Comparator.comparing(Apartment::getAddress);
    public static Comparator<Apartment> floorComp = Comparator.comparing(Apartment::getFloor);
    public static Comparator<Apartment> numOfRoomsComp = Comparator.comparingInt(a -> a.getRooms().size());
    public static Comparator<Apartment> areaComp = Comparator.comparing(Apartment::getArea);
}
