package pers.sherry.gof.command.invoker;

import pers.sherry.gof.command.command.Command;

import java.util.Optional;

/**
 * Invoker - 调用者
 */
public class ButtonInvoker {

    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void onClick(){
        Optional.ofNullable(command).ifPresent(Command::execute);
    }

}
