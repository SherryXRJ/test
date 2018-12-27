package pers.sherry.gof.iterator.iterator;

/**
 * Iterator - 迭代器
 */
public interface AbstractIterator<T> {

    boolean hasNext();

    boolean hasPrevious();

    T next();

    T previous();

    int previousIndex();

    void remove();

}
