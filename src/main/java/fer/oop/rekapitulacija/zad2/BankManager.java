package fer.oop.rekapitulacija.zad2;

public class BankManager {
    public BankManager() {
    }

    public void payment(Worker worker, double amount) {
        System.out.println(worker.getName() + " - " + worker.getBankNumber() + ": " + amount);
    }
}
