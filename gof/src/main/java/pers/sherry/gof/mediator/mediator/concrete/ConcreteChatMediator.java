package pers.sherry.gof.mediator.mediator.concrete;

import pers.sherry.gof.mediator.colleague.AbstractChatter;
import pers.sherry.gof.mediator.colleague.concrete.ConcreteChatter;
import pers.sherry.gof.mediator.mediator.AbstractChatMediator;

import java.util.Collection;
import java.util.Optional;

/**
 * Concrete Mediator
 */
public class ConcreteChatMediator extends AbstractChatMediator {

    @Override
    public void notify(AbstractChatter sender, String message) {
        Optional.ofNullable(chatters)
                .map(Collection::stream)
                .get()
                .filter(receiver -> !sender.equals(receiver))
                .forEach(receiver -> receiver.receiver(sender.getName(), message));
    }
}
