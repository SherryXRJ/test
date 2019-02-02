package pers.sherry.gof.decorator.concretedecorator;

import pers.sherry.gof.decorator.component.Computer;
import pers.sherry.gof.decorator.decorator.ComputerDecorator;

/**
 * concrete decorator 具体装饰
 */
public class NvidiaDecorator extends ComputerDecorator{

    private Computer mComputer;

    public NvidiaDecorator(Computer computer) {
        super(computer,"Nvidia GPU");
    }

    @Override
    public void displayParams() {
        System.out.println(this.name + " GTX 1050.");
    }
}
