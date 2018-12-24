package pers.sherry.gof.decorator.concretedecorator;

import pers.sherry.gof.decorator.component.Computer;
import pers.sherry.gof.decorator.decorator.ComputerDecorator;

public class AmdDecorator extends ComputerDecorator{

    public AmdDecorator(Computer computer) {
        super(computer, "AMD CPU");
    }

    @Override
    public void displayParams() {
        System.out.println(this.name + " Ryzen 7.");
    }
}
