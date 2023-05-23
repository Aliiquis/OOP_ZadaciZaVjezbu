package fer.oop.zzv12;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Room implements Comparable<Room> {
    private final FloorType floorType;
    private final BigDecimal area;
    private final boolean heated;
    private final int numberOfWindows;
    private final Color wallColor;

    public Room(FloorType floorType, BigDecimal area, boolean heated, int numberOfWindows, Color wallColor) {
        this.floorType = floorType;
        this.area = area;
        this.heated = heated;
        this.numberOfWindows = numberOfWindows;
        this.wallColor = wallColor;
    }

    public FloorType getFloorType() {
        return floorType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public boolean isHeated() {
        return heated;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public Color getWallColor() {
        return wallColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return heated == room.heated && numberOfWindows == room.numberOfWindows && floorType == room.floorType && Objects.equals(area, room.area) && Objects.equals(wallColor, room.wallColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorType, area, heated, numberOfWindows, wallColor);
    }

    @Override
    public int compareTo(Room o) {
        if (this.numberOfWindows != o.numberOfWindows) {
            return Integer.compare(this.numberOfWindows, o.numberOfWindows);
        } else if (this.floorType != o.floorType) {
            return this.floorType.compareTo(o.floorType);
        } else if (this.area.compareTo(o.area) != 0) {
            return this.area.compareTo(o.area);
        } else {
            return Integer.compare(this.wallColor.getRGB(), o.wallColor.getRGB());
        }
    }
}
