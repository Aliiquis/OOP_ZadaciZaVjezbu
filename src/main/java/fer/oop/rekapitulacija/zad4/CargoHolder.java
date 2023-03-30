package fer.oop.rekapitulacija.zad4;

import java.util.ArrayList;

public abstract class CargoHolder implements Loadable {
    protected double weight;
    private double maxCargoWeight;
    protected ArrayList<Object> cargoList = new ArrayList<>();

    public CargoHolder(double weight, double maxCargoWeight) {
        this.weight = weight;
        this.maxCargoWeight = maxCargoWeight;
    }

    protected double getMaxCargoWeight() {
        return maxCargoWeight;
    }
}
