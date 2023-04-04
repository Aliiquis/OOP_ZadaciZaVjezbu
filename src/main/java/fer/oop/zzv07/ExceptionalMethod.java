package fer.oop.zzv07;

public class ExceptionalMethod {
    public static void main(String[] args) {
        exceptionalMethod(new String[]{"a", "b", "c", null});
    }

    private static void exceptionalMethod(String[] input) {
        String result = "";
        for (String string : input) {
            try {
                String upper = string.toUpperCase();
                result += upper.toCharArray()[0];
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("finally");
            }
        }
        System.out.println(result);
    }
}
