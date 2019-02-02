package pers.sherry.gof.iterator.aggregate;

import pers.sherry.gof.iterator.iterator.AbstractIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Aggregate
 */
public abstract class AbstractObjectList<T> {

    protected List<T> list = new ArrayList<>();

    public abstract void add(T t);

    public abstract void remove(int index);

    public abstract int size();

    public abstract T get(int index);

    public abstract AbstractIterator iterator();
}
