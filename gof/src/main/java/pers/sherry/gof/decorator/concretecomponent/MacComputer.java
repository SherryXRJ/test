package pers.sherry.gof.decorator.concretecomponent;

import pers.sherry.gof.decorator.component.Computer;

/**
 * concrete component
 */
public class MacComputer extends Computer{

    private String slogan;

    public MacComputer(String name) {
        super(name);
        slogan = " Think Different.";
    }

    @Override
    public void display() {
        System.out.println(name + slogan);
    }
}
