package pers.sherry.gof.command.command.concrete;

import pers.sherry.gof.command.command.Command;
import pers.sherry.gof.command.receiver.ExitReceiver;
import pers.sherry.gof.command.receiver.Receiver;
import pers.sherry.gof.command.receiver.StartReceiver;

/**
 * Concrete Command - 具体实现命令
 */
public class ExitCommand extends Command {

    public ExitCommand() {
        receiver = new ExitReceiver();
    }

    @Override
    public void execute() {
        receiver.display();
    }

}
