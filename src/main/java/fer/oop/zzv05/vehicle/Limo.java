package fer.oop.zzv05.vehicle;

public class Limo extends Vehicle implements LoadPassengers {
    private double length;
    private int noOfSeats;
    private boolean sunRoof;

    public Limo(String regNo, String model, double length, int noOfSeats, boolean sunRoof) {
        super(regNo, model);
        this.length = length;
        this.noOfSeats = noOfSeats;
        this.sunRoof = sunRoof;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public boolean isSunRoof() {
        return sunRoof;
    }

    public void setSunRoof(boolean sunRoof) {
        this.sunRoof = sunRoof;
    }

    public int getMaxPassengers() {
        return noOfSeats;
    }

    @Override
    public String toString() {
        return super.toString() + ", length=" + length + ", noOfSeats=" + noOfSeats + ", sunRoof=" + sunRoof;
    }
}
