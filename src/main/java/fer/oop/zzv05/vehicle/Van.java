package fer.oop.zzv05.vehicle;

public abstract class Van extends Vehicle {
    private double height;

    public Van(String regNo, String model, double height) {
        super(regNo, model);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + ", height=" + height;
    }
}
