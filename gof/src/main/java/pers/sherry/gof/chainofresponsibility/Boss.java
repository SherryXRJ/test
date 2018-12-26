package pers.sherry.gof.chainofresponsibility;

/**
 * Concrete Handler - 具体处理者
 */
public class Boss extends Approver{

    @Override
    protected void handleRequest(int param) {
        if (param > 1000) {
            System.out.println("Boss Handled");
        }
    }
}
