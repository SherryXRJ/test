package pers.sherry.gof.memento.originator;

import pers.sherry.gof.memento.memento.ChessmanMemento;

/**
 * Originator - 原发器
 */
public class Chessman {

    private int x;

    private int y;

    private String desc;

    public Chessman(int x, int y, String desc) {
        this.x = x;
        this.y = y;
        this.desc = desc;
    }

    public ChessmanMemento createChessmanMemento(){
        return new ChessmanMemento(x, y, desc);
    }

    public void restore(ChessmanMemento memento) {
        this.x = memento.getX();
        this.y = memento.getY();
        this.desc = memento.getDesc();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Chessman{" +
                "x=" + x +
                ", y=" + y +
                ", desc='" + desc + '\'' +
                '}';
    }
}
