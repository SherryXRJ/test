package pers.sherry.gof.observer.subject.concrete;

import pers.sherry.gof.observer.observer.Observer;
import pers.sherry.gof.observer.subject.Observable;

/**
 * Concrete Observable - 具体被观察者
 */
public class ConcreteObservable extends Observable {

    @Override
    public void notifyObservers() {
        observerList.forEach(Observer::update);
    }
}
