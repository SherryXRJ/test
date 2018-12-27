package pers.sherry.gof.iterator.iterator.concrete;

import pers.sherry.gof.iterator.aggregate.AbstractObjectList;
import pers.sherry.gof.iterator.iterator.AbstractIterator;

import java.util.NoSuchElementException;

/**
 * Concrete Iterator
 */
public class ConcreteIterator<T> implements AbstractIterator {

    private AbstractObjectList<T> list;

    private int cursor;

    public ConcreteIterator(AbstractObjectList<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return cursor < list.size();
    }

    @Override
    public boolean hasPrevious() {
        return cursor != 0;
    }

    @Override
    public T next() {
        int i = cursor;
        if (i > list.size()) {
            throw new NoSuchElementException();
        }
        cursor = i + 1;
        return list.get(i);
    }

    @Override
    public T previous() {
        return list.get(--cursor);
    }

    @Override
    public int previousIndex() {
        return cursor - 1;
    }

    @Override
    public void remove() {
        list.remove(cursor);
    }
}
