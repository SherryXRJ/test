package pers.sherry.gof.decorator.concretedecorator;

import pers.sherry.gof.decorator.component.Computer;
import pers.sherry.gof.decorator.decorator.ComputerDecorator;

/**
 * concrete decorator 具体装饰
 */
public class IntelDecorator extends ComputerDecorator{

    public IntelDecorator(Computer computer) {
        super(computer, "Intel CPU");
    }


    @Override
    public void displayParams() {
        System.out.println(this.name + " I7 8700.");
    }
}
