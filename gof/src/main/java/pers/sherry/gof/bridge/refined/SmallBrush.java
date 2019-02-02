package pers.sherry.gof.bridge.refined;

import pers.sherry.gof.bridge.implementor.Color;
import pers.sherry.gof.bridge.Image;
import pers.sherry.gof.bridge.abstraction.Brush;

/**
 * Refined Abstraction
 */
public class SmallBrush extends Brush {

    public SmallBrush(Color color) {
        super(color);
    }

    @Override
    public void paint(Image image) {
        System.out.println("Small brush paint " + mColor.getColor());
    }
}
