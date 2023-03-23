package fer.oop.zzv05.device;

public class Netbook extends Laptop implements Portable {
    public Netbook(String model, String manufacturer, String operatingSystem, int batteryCapacity, double weight) {
        super(model, manufacturer, operatingSystem, batteryCapacity, weight);
    }

    public String getModel() {
        return super.getModel();
    }

    public int getBatteryCapacity() {
        return super.getBatteryCapacity();
    }

    @Override
    public String getComputerType() {
        return "netbook laptop computer";
    }

    @Override
    public int calculatePortabilityScore() {
        return 1;
    }
}
