package pers.sherry.gof.mediator.colleague.concrete;

import pers.sherry.gof.mediator.colleague.AbstractChatter;
import pers.sherry.gof.mediator.mediator.AbstractChatMediator;

/**
 * Concrete Colleague - 具体同事类
 */
public class ConcreteChatter extends AbstractChatter {

    public ConcreteChatter(String name, AbstractChatMediator mediator) {
        super(name, mediator);
    }

    @Override
    public void chat(String message) {
        mediator.notify(this, message);
    }
}
