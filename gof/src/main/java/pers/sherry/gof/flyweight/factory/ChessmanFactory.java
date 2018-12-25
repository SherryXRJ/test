package pers.sherry.gof.flyweight.factory;

import pers.sherry.gof.flyweight.flyweight.Chessman;
import pers.sherry.gof.flyweight.flyweight.concrete.BlackChessman;
import pers.sherry.gof.flyweight.flyweight.concrete.WhiteChessman;

import java.util.HashMap;

/**
 * 工厂类
 */
public class ChessmanFactory {

    private static volatile ChessmenHolder instance;

    private ChessmanFactory(){}

    public static ChessmenHolder getInstance(){
        if (null == instance) {
            synchronized (ChessmanFactory.class) {
                if (null == instance) {
                    instance = new ChessmenHolder();
                }
            }
        }
        return instance;
    }


    public static class ChessmenHolder {

        private static HashMap<String, Chessman> chessmen;

        private ChessmenHolder(){
            chessmen = new HashMap<>();
        }

        /**
         * non-thread safe
         */
        public Chessman getChessman(String color){
            if (chessmen.containsKey(color)) {
                return chessmen.get(color);
            } else {
                if ("black".equals(color)) {
                    chessmen.put(color, new BlackChessman());
                } else if ("white".equals(color)) {
                    chessmen.put(color, new WhiteChessman());
                } else {
                    throw new RuntimeException("Unknown Color");
                }
                return chessmen.get(color);
            }
        }

        public int getChessTypeCount() {
            return chessmen.size();
        }
    }
}
