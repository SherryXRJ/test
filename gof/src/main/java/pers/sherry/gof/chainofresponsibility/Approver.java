package pers.sherry.gof.chainofresponsibility;

/**
 * Handler - 抽象处理者
 */
public abstract class Approver {

    protected Approver successor;

    public void setSuccessor (Approver successor){
        this.successor = successor;
    }

    protected abstract void handleRequest(int param);
}
