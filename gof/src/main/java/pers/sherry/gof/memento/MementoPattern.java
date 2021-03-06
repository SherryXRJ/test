package pers.sherry.gof.memento;

import pers.sherry.gof.memento.caretaker.ChessmanCaretaker;
import pers.sherry.gof.memento.originator.Chessman;

/**
 * Memento Pattern - 备忘录模式
 */
public class MementoPattern {

    public static void main(String[] args) {
        ChessmanCaretaker caretaker = new ChessmanCaretaker();
        Chessman chessman = new Chessman(1, 5, "兵");
        caretaker.addMemento(chessman.createChessmanMemento());
        System.out.println(chessman);

        chessman.setY(6);
        caretaker.addMemento(chessman.createChessmanMemento());
        System.out.println(chessman);


        chessman.setX(2);
        caretaker.addMemento(chessman.createChessmanMemento());
        System.out.println(chessman);

        chessman.setX(3);
        System.out.println(chessman);

        chessman.restore(caretaker.getMemento());
        System.out.println(chessman);

        chessman.setY(7);
        System.out.println(chessman);

        chessman.restore(caretaker.getMemento());
        System.out.println(chessman);
        chessman.restore(caretaker.getMemento());
        System.out.println(chessman);
        chessman.restore(caretaker.getMemento());
        System.out.println(chessman);
    }

}
