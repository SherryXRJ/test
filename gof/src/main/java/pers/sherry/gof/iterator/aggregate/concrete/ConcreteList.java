package pers.sherry.gof.iterator.aggregate.concrete;

import pers.sherry.gof.iterator.aggregate.AbstractObjectList;
import pers.sherry.gof.iterator.iterator.AbstractIterator;
import pers.sherry.gof.iterator.iterator.concrete.ConcreteIterator;

/**
 * Concrete Aggregate
 */
public class ConcreteList extends AbstractObjectList<String> {
    @Override
    public void add(String s) {
        list.add(s);
    }

    @Override
    public void remove(int index) {
        list.remove(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String get(int index) {
        return list.get(index);
    }

    @Override
    public AbstractIterator iterator() {
        return new ConcreteIterator<>(this);
    }
}
