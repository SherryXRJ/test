package pers.sherry.gof.mediator.mediator;

import pers.sherry.gof.mediator.colleague.AbstractChatter;

import java.util.HashSet;
import java.util.Set;

/**
 * Mediator - 抽象中介者
 */
public abstract class AbstractChatMediator {

    protected Set<AbstractChatter> chatters = new HashSet<>();

    public abstract void notify(AbstractChatter sender, String message);

    public void register(AbstractChatter chatter) {
        chatters.add(chatter);
    }

    public void register(AbstractChatter... chatters) {
        for (AbstractChatter c : chatters) {
            register(c);
        }
    }
}
