package pers.sherry.gof.adapter.clazz;

import pers.sherry.gof.adapter.Target;

/**
 * 6.适配器模式 - 类适配器
 */
public class ClassAdapterPattern {

    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.request();
    }
}
