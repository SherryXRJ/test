package pers.sherry.gof.iterator;

import pers.sherry.gof.iterator.aggregate.AbstractObjectList;
import pers.sherry.gof.iterator.aggregate.concrete.ConcreteList;
import pers.sherry.gof.iterator.iterator.AbstractIterator;

/**
 * Iterator Pattern - 迭代器模式
 */
public class IteratorPattern {

    public static void main(String[] args) {
        AbstractObjectList<String> list = new ConcreteList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        AbstractIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-------------------------------");

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        System.out.println("-------------------------------");

        while (iterator.hasNext()) {
            iterator.remove();
            System.out.println(list.size());
        }
    }
}
