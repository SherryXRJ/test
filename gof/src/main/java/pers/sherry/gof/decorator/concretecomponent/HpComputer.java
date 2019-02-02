package pers.sherry.gof.decorator.concretecomponent;

import pers.sherry.gof.decorator.component.Computer;

/**
 * concrete component
 */
public class HpComputer extends Computer{

    private String slogan;

    public HpComputer(String name) {
        super(name);
        slogan = " Expanding Possibilities.";
    }

    @Override
    public void display() {
        System.out.println(name + slogan);
    }
}
