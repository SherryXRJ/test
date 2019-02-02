package pers.sherry.gof.chainofresponsibility;

/**
 * Concrete Handler - 具体处理者
 */
public class GroupLeader extends Approver{

    @Override
    protected void handleRequest(int param) {
        if (param <= 100) {
            System.out.println("Group Leader Handled");
        } else {
            successor.handleRequest(param);
        }
    }
}
