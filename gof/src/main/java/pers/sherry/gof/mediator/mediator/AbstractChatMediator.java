package pers.sherry.gof.mediator.mediator;

import pers.sherry.gof.mediator.colleague.AbstractChatter;

import java.util.HashSet;
import java.util.Set;

/**
 * Mediator - 抽象中介者
 */
public abstract class AbstractChatMediator {

    private Set<AbstractChatter> chatters = new HashSet<>();

}
