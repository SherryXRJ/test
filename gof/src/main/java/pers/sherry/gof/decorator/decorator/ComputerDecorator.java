package pers.sherry.gof.decorator.decorator;

import pers.sherry.gof.decorator.component.Computer;

/**
 * decorator  装饰
 */
public abstract class ComputerDecorator extends Computer{

    protected Computer mComputer;

    public ComputerDecorator(Computer computer, String name) {
        super(name);
        mComputer = computer;
    }

    @Override
    public void display() {
        mComputer.display();
        System.out.println("with " + this.name + ".");
    }

    public abstract void displayParams();
}
