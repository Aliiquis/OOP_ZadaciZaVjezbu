package fer.oop.zzv12;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Objects;

public class BathRoom extends Room {
    private final boolean hasBidet;
    private final int numberOfSinks;
    private final String bathtubType;

    public BathRoom(boolean hasBidet, int numberOfSinks, String bathtubType, FloorType floorType, BigDecimal area, boolean heated, int numberOfWindows, Color wallColor) {
        super(floorType, area, heated, numberOfWindows, wallColor);
        this.hasBidet = hasBidet;
        this.numberOfSinks = numberOfSinks;
        this.bathtubType = bathtubType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BathRoom bathRoom = (BathRoom) o;
        return hasBidet == bathRoom.hasBidet && numberOfSinks == bathRoom.numberOfSinks && Objects.equals(bathtubType, bathRoom.bathtubType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasBidet, numberOfSinks, bathtubType);
    }
}
