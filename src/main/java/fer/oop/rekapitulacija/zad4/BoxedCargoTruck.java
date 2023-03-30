package fer.oop.rekapitulacija.zad4;

public class BoxedCargoTruck extends CargoHolder {
    public BoxedCargoTruck(double weight, double maxCargoWeight) {
        super(weight, maxCargoWeight);
    }

    @Override
    public boolean add(Object o) {
        if (o instanceof Cargo) {
            Cargo cargo = (Cargo) o;
            if (cargo.getWeight() + super.getWeight() <= super.getMaxCargoWeight()) {
                super.cargoList.add(cargo);
                super.weight += cargo.getWeight();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof Cargo) {
            Cargo cargo = (Cargo) o;
            if (super.cargoList.contains(cargo)) {
                super.cargoList.remove(cargo);
                super.weight -= cargo.getWeight();
                return true;
            }
        }
        return false;
    }

    @Override
    public double getWeight() {
        return super.weight;
    }
}
