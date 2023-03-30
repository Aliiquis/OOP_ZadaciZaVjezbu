package fer.oop.rekapitulacija.zad4;

import java.util.ArrayList;

public class Container implements Loadable {
    private double weight;
    private double volume;
    private double maxCargoVolume;
    private int id;
    private ArrayList<Cargo> cargoList = new ArrayList<>();

    private double currentVolume = 0;

    public Container(double weight, double volume, double maxCargoVolume, int id) {
        this.weight = weight;
        this.volume = volume;
        this.maxCargoVolume = maxCargoVolume;
        this.id = id;
    }

    @Override
    public boolean add(Object o) {
        Cargo cargo = (Cargo) o;
        if (cargo.getVolume() + this.currentVolume <= this.maxCargoVolume) {
            this.cargoList.add(cargo);
            this.currentVolume += cargo.getVolume();
            this.weight += cargo.getWeight();
            return true;
        }
        return false;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public boolean remove(Object o) {
        Cargo cargo = (Cargo) o;
        if (cargoList.contains(cargo)) {
            this.cargoList.remove(cargoList.indexOf(cargo));
            this.currentVolume -= cargo.getVolume();
            this.weight -= cargo.getWeight();
            return true;
        }
        return false;
    }
}
