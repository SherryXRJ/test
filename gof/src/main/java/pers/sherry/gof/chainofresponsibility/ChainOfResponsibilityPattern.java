package pers.sherry.gof.chainofresponsibility;

/**
 * 13.职责链设计模式 - Chain Of Responsibility Pattern
 */
public class ChainOfResponsibilityPattern {

    public static void main(String[] args){
        Approver groupLeader = new GroupLeader();
        Approver manager = new Manager();
        Approver boss = new Boss();

        groupLeader.setSuccessor(manager);
        manager.setSuccessor(boss);

        groupLeader.handleRequest(100000);
    }

}
