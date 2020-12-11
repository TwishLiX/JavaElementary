package homework10_iterator;

import java.util.NoSuchElementException;

public class CustomIterator implements Iterator {
    private Object[] array;
    private int count;
    private int index;

    public CustomIterator(Object[] array) {
        this.array = array;
        this.count = array.length;
    }

    @Override
    public boolean hasNext() {
        return index < count;
    }

    @Override
    public Object next() {
        if (index < count) {
            return array[index++];
        } else {
            throw new NoSuchElementException("No such element.");
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove an element from array.");
    }
}
