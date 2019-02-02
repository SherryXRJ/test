package pers.sherry.gof.decorator;

import pers.sherry.gof.decorator.component.Computer;
import pers.sherry.gof.decorator.concretecomponent.HpComputer;
import pers.sherry.gof.decorator.concretecomponent.MacComputer;
import pers.sherry.gof.decorator.concretedecorator.AmdDecorator;
import pers.sherry.gof.decorator.concretedecorator.AmdGPUDecorator;
import pers.sherry.gof.decorator.concretedecorator.IntelDecorator;
import pers.sherry.gof.decorator.concretedecorator.NvidiaDecorator;
import pers.sherry.gof.decorator.decorator.ComputerDecorator;

/**
 * 9.装饰模式
 */
public class DecoratorPattern {

    public static void main(String[] args) {
//        transparent();
        translucent();
    }


    /**
     * 透明装饰模式
     */
    private static void transparent(){
        //  组件
        Computer hp = new HpComputer("Hp Envy 14");
        Computer mac = new MacComputer("Mac mini");

        //  装饰 GPU
        hp = new NvidiaDecorator(hp);
        mac = new AmdGPUDecorator(mac);

        //  装饰CPU
        hp = new IntelDecorator(hp);
        mac = new AmdDecorator(mac);

        hp.display();
        System.out.println("-----------------------------------");
        mac.display();
    }

    /**
     * 半透明装饰模式
     */
    private static void translucent(){
        //  组件
        Computer hp = new HpComputer("Hp Envy 14");
        Computer mac = new MacComputer("Mac mini");

        //  装饰  GPU
        ComputerDecorator hpWithNvidiaGPU = new NvidiaDecorator(hp);
        ComputerDecorator macWithAmdGPU = new AmdGPUDecorator(mac);

        //  装饰  CPU
        ComputerDecorator hpWithIntelCPU = new IntelDecorator(hpWithNvidiaGPU);
        ComputerDecorator macWithIntelCPU = new AmdDecorator(macWithAmdGPU);

        hpWithIntelCPU.display();
        hpWithNvidiaGPU.displayParams();
        hpWithIntelCPU.displayParams();
        System.out.println("-----------------------------------");
        macWithIntelCPU.display();
        macWithAmdGPU.displayParams();
        macWithIntelCPU.displayParams();
    }

}
