package pers.sherry.gof.command;

import pers.sherry.gof.command.command.concrete.StartCommand;
import pers.sherry.gof.command.invoker.ButtonInvoker;

/**
 * Command Pattern - 命令模式
 */
public class CommandPattern {

    public static void main(String[] args) {
        StartCommand command = new StartCommand();
        ButtonInvoker invoker = new ButtonInvoker();
        invoker.setCommand(command);
        invoker.onClick();
    }

}
