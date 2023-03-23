package fer.oop.zzv05.library;

public class TextBook extends Book implements Purchasable {
    private String subject;
    private double deposit;

    public TextBook(int id, String name, String author, String subject, double deposit) {
        super(id, name, author);
        this.subject = subject;
        this.deposit = deposit;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public boolean hasCashDeposit() {
        return getCashDepositAmount() != 0.;
    }

    @Override
    public double getCashDepositAmount() {
        return deposit;
    }

    @Override
    public int getLoanPeriod() {
        return 120;
    }

    @Override
    public String toString() {
        return super.toString() + ' ' + subject;
    }
}
