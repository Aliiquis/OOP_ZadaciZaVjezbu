package fer.oop.rekapitulacija.zad4;

public class ContainerShip extends CargoHolder {
    private int maxContainers;

    public ContainerShip(double weight, double maxCargoWeight, int maxContainers) {
        super(weight, maxCargoWeight);
        this.maxContainers = maxContainers;
    }

    @Override
    public boolean add(Object o) {
        if (o instanceof Container) {
            Container container = (Container) o;
            if (container.getWeight() + super.getWeight() <= super.getMaxCargoWeight() && cargoList.size() <= maxContainers) {
                super.cargoList.add(container);
                super.weight += container.getWeight();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof Container) {
            Container container = (Container) o;
            if (super.cargoList.contains(container)) {
                super.cargoList.remove(container);
                super.weight -= container.getWeight();
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
