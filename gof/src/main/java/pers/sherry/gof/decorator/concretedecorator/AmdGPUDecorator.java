package pers.sherry.gof.decorator.concretedecorator;

import pers.sherry.gof.decorator.component.Computer;
import pers.sherry.gof.decorator.decorator.ComputerDecorator;

public class AmdGPUDecorator extends ComputerDecorator{

    public AmdGPUDecorator(Computer computer) {
        super(computer, "AMD GPU");
    }

    @Override
    public void displayParams() {
        System.out.println(this.name + " Radeon RX Vega.");
    }
}
