package pers.sherry.gof.flyweight.flyweight;

import pers.sherry.gof.flyweight.flyweight.unsharedconcrete.Position;

/**
 * flyweight - 抽象享元类
 */
public abstract class Chessman {


    public abstract String getColor();

    public void display(Position position) {
        System.out.println("The color of chessman is " + getColor() + ", position x = " + position.getX() + ", y = " + position.getY());
    }

}
