package fer.oop.zzv08;

public class CountableKeyValueMapEntry<V> extends KeyValueMapEntry<Integer, V> {
    private static int c = 0;
    private int id;

    public CountableKeyValueMapEntry(Integer key, V value) {
        super(key, value);
        this.id = c;
        c++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString() + "id=" + id + '}';
    }
}
