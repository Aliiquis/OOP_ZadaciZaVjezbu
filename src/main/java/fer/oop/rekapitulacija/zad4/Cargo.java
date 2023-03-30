package fer.oop.rekapitulacija.zad4;

public abstract class Cargo {
    private double weight;
    private double volume;
    private int id;

    public Cargo(double weight, double volume, int id) {
        this.weight = weight;
        this.volume = volume;
        this.id = id;
    }

    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }
}
