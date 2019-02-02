package pers.sherry.gof.command.command;

import pers.sherry.gof.command.receiver.Receiver;

/**
 * Command - 抽象命令
 */
public abstract class Command {

    protected Receiver receiver;


    public abstract void execute();
}
