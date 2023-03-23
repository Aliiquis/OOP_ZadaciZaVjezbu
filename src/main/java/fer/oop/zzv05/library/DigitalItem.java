package fer.oop.zzv05.library;

public class DigitalItem extends LibraryItem implements Purchasable {
    private String type;
    private double deposit;

    public DigitalItem(int id, String name, String type, double deposit) {
        super(id, name);
        this.type = type;
        this.deposit = deposit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public boolean hasCashDeposit() {
        return true;
    }

    @Override
    public double getCashDepositAmount() {
        return deposit;
    }

    @Override
    public int getLoanPeriod() {
        return 30;
    }

    @Override
    public String toString() {
        return super.toString() + ' ' + type;
    }
}
