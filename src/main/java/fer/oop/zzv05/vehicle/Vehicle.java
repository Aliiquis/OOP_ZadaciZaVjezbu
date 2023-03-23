package fer.oop.zzv05.vehicle;

public abstract class Vehicle {
    private String registrationNo;
    private String model;

    public Vehicle(String regNo, String model) {
        this.registrationNo = regNo;
        this.model = model;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return registrationNo + ", " + model;
    }
}
