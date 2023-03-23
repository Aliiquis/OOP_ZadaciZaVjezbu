package fer.oop.zzv05.vehicle;

public class CargoVan extends Van implements LoadCargo {
    private double maxSpace;

    public CargoVan(String regNo, String model, double height, double maxSpace) {
        super(regNo, model, height);
        this.maxSpace = maxSpace;
    }

    public double getMaxSpace() {
        return maxSpace;
    }

    public void setMaxSpace(double maxSpace) {
        this.maxSpace = maxSpace;
    }

    @Override
    public String toString() {
        return super.toString() + ", maxSpace=" + maxSpace;
    }
}
