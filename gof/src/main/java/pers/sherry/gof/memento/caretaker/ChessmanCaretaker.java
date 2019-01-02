package pers.sherry.gof.memento.caretaker;

import pers.sherry.gof.memento.memento.ChessmanMemento;

import java.util.Stack;

/**
 * Caretaker - 负责人
 */
public class ChessmanCaretaker {

    private Stack<ChessmanMemento> mementos = new Stack<>();

    public void addMemento(ChessmanMemento memento) {
        mementos.push(memento);
    }

    public ChessmanMemento getMemento() {
        return mementos.pop();
    }
}
