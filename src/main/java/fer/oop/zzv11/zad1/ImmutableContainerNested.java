package fer.oop.zzv11.zad1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ImmutableContainerNested implements Iterable<Integer> {
    private Integer[] numbers;

    public ImmutableContainerNested(Integer... num) {
        numbers = new Integer[num.length];
        for (int i = 0; i < num.length; i++)
            numbers[i] = num[i];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator(this);
    }

    static class CustomIterator implements Iterator<Integer> {
        private int index;
        private ImmutableContainerNested container;

        public CustomIterator(ImmutableContainerNested container) {
            this.index = container.numbers.length - 1;
            this.container = container;
        }

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                index -= 2;
                return container.numbers[index + 2];
            } else throw new NoSuchElementException();
        }
    }
}
