package fer.oop.zzv04;

public class Vehicle {
    private String regNo;
    private String model;
    private int year;
    private double price;

    public Vehicle(String regNo, String model, int year, double price) {
        this.regNo = regNo;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPricePerDay() {
        return price * 24;
    }

    public final double getPricePerMonth() {
        return getPricePerDay() * 30;
    }

    public static Vehicle getNewestVehicle(Vehicle... vehicles) {
        int maxYear = 0;
        Vehicle newest = null;
        for (Vehicle v : vehicles) {
            if (v.year > maxYear) {
                maxYear = v.year;
                newest = v;
            }
        }
        return newest;
    }

    public static void printAllVehiclesWithCargoSpaceGreaterThan(double cargoSpace, Vehicle... vehicles) {
        System.out.println("Vehicles with cargo space greater than " + cargoSpace + ':');
        for (Vehicle v : vehicles) {
            if (v instanceof Car) {
                if (((Car) v).getCargoSpace() > cargoSpace) {
                    System.out.println(v);
                }
            }
            if (v instanceof CargoVan) {
                if (((CargoVan) v).getMaxLoad() > cargoSpace) {
                    System.out.println(v);
                }
            }
        }
    }

    @Override
    public String toString() {
        return regNo + ' ' + model + ' ' + year + ' ' + price;
    }
}
