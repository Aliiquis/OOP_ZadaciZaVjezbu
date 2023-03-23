package fer.oop.zzv05.vehicle;

public class PassengerVan extends Van implements LoadPassengers {
    private int noOfPassengers;

    public PassengerVan(String regNo, String model, double height, int noOfPassengers) {
        super(regNo, model, height);
        this.noOfPassengers = noOfPassengers;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public int getMaxPassengers() {
        return noOfPassengers;
    }

    @Override
    public String toString() {
        return super.toString() + ", noOfPassengers=" + noOfPassengers;
    }
}
