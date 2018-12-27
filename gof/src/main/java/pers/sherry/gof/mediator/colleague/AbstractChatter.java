package pers.sherry.gof.mediator.colleague;

import pers.sherry.gof.mediator.mediator.AbstractChatMediator;

/**
 * Colleague - 抽象同事类
 */
public abstract class AbstractChatter {

    protected AbstractChatMediator mediator;

    public AbstractChatter(AbstractChatMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void chat(String message);

}
