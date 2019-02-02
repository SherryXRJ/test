package pers.sherry.gof.chainofresponsibility;

/**
 * Concrete Handler - 具体处理者
 */
public class Manager extends Approver{

    @Override
    protected void handleRequest(int param) {
        if (param > 100 && param <= 1000) {
            System.out.println("Manager Handled");
        } else {
            successor.handleRequest(param);
        }
    }
}
