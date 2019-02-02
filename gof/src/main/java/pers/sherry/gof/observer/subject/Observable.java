package pers.sherry.gof.observer.subject;

import pers.sherry.gof.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject - 被观察者
 */
public abstract class Observable {

    protected List<Observer> observerList = new ArrayList<>();

    public void attach(Observer o) {
        observerList.add(o);
    }

    public void dettach(Observer o) {
        observerList.remove(o);
    }

    public abstract void notifyObservers();
}
