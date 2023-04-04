package fer.oop.zzv07;

public class TwoArguments {
    public static void main(String[] args) {
        if (args.length != 2) throw new IllegalArgumentException("Program needs 2 arguments!");
        System.out.println("Good!");
    }
}
