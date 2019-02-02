package pers.sherry.gof.flyweight;

import pers.sherry.gof.flyweight.factory.ChessmanFactory;
import pers.sherry.gof.flyweight.flyweight.Chessman;
import pers.sherry.gof.flyweight.flyweight.unsharedconcrete.Position;

/**
 * 11.享元模式
 */
public class FlyweightPattern {

    public static void main(String[] args) {
        Chessman blackChessman1 = ChessmanFactory.getInstance().getChessman("black");
        Chessman blackChessman2 = ChessmanFactory.getInstance().getChessman("black");

        Chessman whiteChessman1 = ChessmanFactory.getInstance().getChessman("white");
        Chessman whiteChessman2 = ChessmanFactory.getInstance().getChessman("white");

        blackChessman1.display(new Position(1, 1));
        blackChessman2.display(new Position(1, 2));

        whiteChessman1.display(new Position(2, 1));
        whiteChessman2.display(new Position(2, 2));

        System.out.println("chessman type count: " + ChessmanFactory.getInstance().getChessTypeCount());
    }
}
