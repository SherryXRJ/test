package pers.sherry.gof.bridge.concreteimplementor;

import pers.sherry.gof.bridge.implementor.Color;

/**
 * concreteimplementor 具体实现类
 */
public class Blue implements Color {

    @Override
    public String getColor() {
        return "Blue";
    }
}
