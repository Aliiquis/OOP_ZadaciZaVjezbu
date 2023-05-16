package fer.oop.zzv11.zad1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ImmutableContainerInner implements Iterable<Integer> {
    private Integer[] numbers;

    public ImmutableContainerInner(Integer... num) {
        numbers = new Integer[num.length];
        for (int i = 0; i < num.length; i++)
            numbers[i] = num[i];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<Integer> {
        private int index;

        public CustomIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < numbers.length;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                index++;
                return numbers[index - 1];
            } else throw new NoSuchElementException();
        }
    }
}
