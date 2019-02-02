package pers.sherry.gof.adapter.clazz;

import pers.sherry.gof.adapter.Adaptee;
import pers.sherry.gof.adapter.Target;

/**
 * 适配器
 */
public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void request() {
        super.specificRequest();
    }
}
