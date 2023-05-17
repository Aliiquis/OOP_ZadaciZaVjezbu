package fer.oop.zzv11.zad1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ImmutableContainerAnon implements Iterable<Integer> {
    private final Integer[] numbers;

    public ImmutableContainerAnon(Integer... num) {
        numbers = new Integer[num.length];
        for (int i = 0; i < num.length; i++)
            numbers[i] = num[i];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = numbers.length - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    index--;
                    return numbers[index + 1];
                } else throw new NoSuchElementException();
            }
        };
    }
}
