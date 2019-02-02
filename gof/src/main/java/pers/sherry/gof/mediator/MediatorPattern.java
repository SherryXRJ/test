package pers.sherry.gof.mediator;

import pers.sherry.gof.mediator.colleague.AbstractChatter;
import pers.sherry.gof.mediator.colleague.concrete.ConcreteChatter;
import pers.sherry.gof.mediator.mediator.AbstractChatMediator;
import pers.sherry.gof.mediator.mediator.concrete.ConcreteChatMediator;

/**
 * Mediator Pattern 中介者模式
 */
public class MediatorPattern {

    public static void main(String[] args) {
        //  中介者
        AbstractChatMediator mediator = new ConcreteChatMediator();

        //  同事类
        AbstractChatter tom = new ConcreteChatter("Tom", mediator);
        AbstractChatter jerry = new ConcreteChatter("Jerry", mediator);
        AbstractChatter peter = new ConcreteChatter("Peter", mediator);

        mediator.register(tom, jerry, peter);

        tom.chat("Hello Jerry and Peter");
        jerry.chat("Oh I can hear u, Jerry");
        peter.chat("I receive all message");
    }
}
