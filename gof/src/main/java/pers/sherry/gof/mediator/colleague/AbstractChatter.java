package pers.sherry.gof.mediator.colleague;

import pers.sherry.gof.mediator.mediator.AbstractChatMediator;

/**
 * Colleague - 抽象同事类
 */
public abstract class AbstractChatter {

    protected String name;

    protected AbstractChatMediator mediator;


    public AbstractChatter(String name, AbstractChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public abstract void chat(String message);

    public void receiver(String senderName, String message){
        System.out.println("FROM: " + senderName + ".| " + message + " | To: " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
