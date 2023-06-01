package fer.oop.zzv13;

import java.util.Objects;

public class PollingStation {
    private int countyId;
    private String county;
    private String label;
    private String place;
    private int id;
    private String title;
    private String location;
    private String address;

    public PollingStation(int countyId, String county, String label, String place, int id, String title, String location, String address) {
        this.countyId = countyId;
        this.county = county;
        this.label = label;
        this.place = place;
        this.id = id;
        this.title = title;
        this.location = location;
        this.address = address;
    }

    public int getCountyId() {
        return countyId;
    }

    public String getCounty() {
        return county;
    }

    public String getLabel() {
        return label;
    }

    public String getPlace() {
        return place;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PollingStation that = (PollingStation) o;
        return countyId == that.countyId && id == that.id && Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countyId, place, id);
    }
}
