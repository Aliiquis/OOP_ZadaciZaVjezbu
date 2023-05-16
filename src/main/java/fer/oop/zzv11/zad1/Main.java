package fer.oop.zzv11.zad1;

public class Main {
    public static void main(String[] args) {
        ImmutableContainerNested containerNested = new ImmutableContainerNested(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Nested static iterator:");
        for (Integer i : containerNested) {
            System.out.print(i + " ");
        }
        System.out.println();

        ImmutableContainerInner containerInner = new ImmutableContainerInner(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Inner iterator:");
        for (Integer i : containerInner) {
            System.out.print(i + " ");
        }
        System.out.println();

        ImmutableContainerLocal containerLocal = new ImmutableContainerLocal(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Local iterator class:");
        for (Integer i : containerLocal) {
            System.out.print(i + " ");
        }
        System.out.println();

        ImmutableContainerAnon containerAnon = new ImmutableContainerAnon(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Anonymous iterator class:");
        for (Integer i : containerAnon) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
