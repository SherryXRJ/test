package pers.sherry.gof.command.command.concrete;

import pers.sherry.gof.command.command.Command;
import pers.sherry.gof.command.receiver.Receiver;
import pers.sherry.gof.command.receiver.StartReceiver;

/**
 * Concrete Command - 具体实现命令
 */
public class StartCommand extends Command {

    public StartCommand() {
        receiver = new StartReceiver();
    }

    @Override
    public void execute() {
        receiver.display();
    }
}
