package fer.oop.zzv08;

public class Main {
    public static void main(String[] args) {
        KeyValueBasic kvb = new KeyValueBasic(1, "value");
        System.out.println(kvb);
        KeyValueParameterized<Integer, String> kvp1 = new KeyValueParameterized<>(2, "value2");
        KeyValueParameterized<Double, Boolean> kvp2 = new KeyValueParameterized<>(0.7, false);
        System.out.println(kvp1 + "\n" + kvp2);
        KeyValueMapEntry<Integer, String> kvme = new KeyValueMapEntry<>(3, "valueold");
        System.out.println(kvme.setValue("valuenew"));
        System.out.println(kvme);

        int n = 5;

        Integer manual_box = Integer.valueOf(n);

        int manual_unbox = manual_box.intValue();

        Integer auto_box = n;

        int auto_unbox = auto_box;

        try {
            Integer ref = null;
            int int_ref = ref.intValue();
        } catch (NullPointerException e) {
            System.out.println("Caught NPE");
        }

        KeyValueMapEntry<Integer, String> real = new KeyValueMapEntry<>(5, "Real Madrid");
        KeyValueMapEntry<Integer, String> dinamo = new KeyValueMapEntry<>(3, "Dinamo");
        KeyValueMapEntry<Integer, Boolean> fake = new KeyValueMapEntry<>(1, false);
        KeyValueMapEntry<Integer, Double> fake2 = new KeyValueMapEntry<>(1, 99.00);
        System.out.println(calculateAverageKey(real, dinamo, fake, fake2));
        System.out.println(calculateAverageKey2(real, dinamo));

        CountableKeyValueMapEntry<String> c1 = new CountableKeyValueMapEntry<>(1, "Dinamo");
        KeyValueMapEntry<Integer, String> c2 = new CountableKeyValueMapEntry<>(9, "Varazdin");
        KeyValueMapEntry<Integer, String> c3 = new KeyValueMapEntry<>(4, "Rijeka");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }

    public static <K extends Number> double calculateAverageKey(KeyValueMapEntry<K, ?>... keyValueMapEntries) {
        double avg = 0;
        for (KeyValueMapEntry<K, ?> entry : keyValueMapEntries) {
            avg += entry.getKey().doubleValue();
        }
        return avg / keyValueMapEntries.length;
    }

    public static <K extends Number, V> double calculateAverageKey2(KeyValueMapEntry<K, V>... keyValueMapEntries) {
        double avg = 0;
        for (KeyValueMapEntry<K, ?> entry : keyValueMapEntries) {
            avg += entry.getKey().doubleValue();
        }
        return avg / keyValueMapEntries.length;
    }
}
