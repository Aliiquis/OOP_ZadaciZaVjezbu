package fer.oop.zzv05.vehicle;

public class Car extends Vehicle implements LoadCargo, LoadPassengers {
    private String carType;
    private int noOfSeats;
    private double cargoSpace;

    public Car(String regNo, String model, String carType, int noOfSeats, double cargoSpace) {
        super(regNo, model);
        this.carType = carType;
        this.noOfSeats = noOfSeats;
        this.cargoSpace = cargoSpace;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public double getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(double cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public double getMaxSpace() {
        return cargoSpace;
    }

    public int getMaxPassengers() {
        return noOfSeats;
    }

    @Override
    public String toString() {
        return super.toString() + ", carType=" + carType + ", noOfSeats=" + noOfSeats + ", cargoSpace=" + cargoSpace;
    }
}
