package pers.sherry.gof.bridge.abstraction;

import pers.sherry.gof.bridge.implementor.Color;
import pers.sherry.gof.bridge.Image;

/**
 * Abstraction 抽象类 (画笔)
 */
public abstract class Brush {

    protected Color mColor;

    public Brush(Color color) {
        mColor = color;
    }

    public abstract void paint(Image image);

}
