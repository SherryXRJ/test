package pers.sherry.gof.observer;

import pers.sherry.gof.observer.observer.Observer;
import pers.sherry.gof.observer.observer.concrete.ConcreteObserver;
import pers.sherry.gof.observer.subject.Observable;
import pers.sherry.gof.observer.subject.concrete.ConcreteObservable;

/**
 * Observer Pattern - 观察者设计模式
 */
public class ObserverPattern {

    public static void main(String[] args) {
        Observable observable = new ConcreteObservable();

        Observer tom = new ConcreteObserver("Tom");
        Observer jerry = new ConcreteObserver("Jerry");
        observable.attach(tom);
        observable.attach(jerry);

        observable.notifyObservers();
    }
}
