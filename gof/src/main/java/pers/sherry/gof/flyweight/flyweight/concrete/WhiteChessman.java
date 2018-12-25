package pers.sherry.gof.flyweight.flyweight.concrete;

import pers.sherry.gof.flyweight.flyweight.Chessman;

/**
 * Concrete Flyweight 具体享元类(内部状态)
 */
public class WhiteChessman extends Chessman {

    @Override
    public String getColor() {
        return "white";
    }
}
