package pers.sherry.gof.decorator.component;


/**
 * component 抽象组件类
 */
public abstract class Computer {

    protected String name;

    public Computer(String name) {
        this.name = name;
    }

    public abstract void display();

}
