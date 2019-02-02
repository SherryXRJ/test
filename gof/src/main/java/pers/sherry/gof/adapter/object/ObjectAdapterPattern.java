package pers.sherry.gof.adapter.object;

import pers.sherry.gof.adapter.Adaptee;
import pers.sherry.gof.adapter.Target;

/**
 * 6.适配器模式 - 对象适配器
 */
public class ObjectAdapterPattern {

    public static void main(String[] args) {
        Target target = new ObjectAdapter(new Adaptee());
        target.request();
    }
}
