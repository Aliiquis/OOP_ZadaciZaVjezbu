package fer.oop.zzv08;

import java.util.Map;

public class KeyValueMapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public KeyValueMapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }

    @Override
    public String toString() {
        return "KeyValueMapEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
