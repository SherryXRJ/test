package pers.sherry.gof.memento.caretaker;

import pers.sherry.gof.memento.memento.ChessmanMemento;

/**
 * Caretaker - 负责人
 */
public class ChessmanCaretaker {

    private ChessmanMemento memento;

    public ChessmanMemento getMemento() {
        return memento;
    }

    public void setMemento(ChessmanMemento memento) {
        this.memento = memento;
    }
}
