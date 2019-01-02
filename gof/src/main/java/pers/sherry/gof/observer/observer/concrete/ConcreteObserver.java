package pers.sherry.gof.observer.observer.concrete;

import pers.sherry.gof.observer.observer.Observer;

/**
 * Concrete Observer - 具体观察者
 */
public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + " observe.");
    }
}
