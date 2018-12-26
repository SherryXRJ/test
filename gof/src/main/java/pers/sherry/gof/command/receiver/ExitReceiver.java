package pers.sherry.gof.command.receiver;

/**
 * Receiver
 */
public class ExitReceiver extends Receiver{

    @Override
    public void display() {
        System.out.println("Exit...");
    }
}
