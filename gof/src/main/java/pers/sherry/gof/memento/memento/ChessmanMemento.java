package pers.sherry.gof.memento.memento;

/**
 * Memento - 备忘录
 */
public class ChessmanMemento {
    private int x;

    private int y;

    private String desc;

    public ChessmanMemento(int x, int y, String desc) {
        this.x = x;
        this.y = y;
        this.desc = desc;
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
}
