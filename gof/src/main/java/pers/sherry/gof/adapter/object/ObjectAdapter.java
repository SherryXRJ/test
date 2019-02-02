package pers.sherry.gof.adapter.object;

import pers.sherry.gof.adapter.Adaptee;
import pers.sherry.gof.adapter.Target;

/**
 * 对象适配器
 */
public class ObjectAdapter implements Target{

    private Adaptee mAdaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.mAdaptee = adaptee;
    }

    @Override
    public void request() {
        mAdaptee.specificRequest();
    }
}
