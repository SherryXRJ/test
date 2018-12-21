package pers.sherry.gof.bridge.refined;

import pers.sherry.gof.bridge.implementor.Color;
import pers.sherry.gof.bridge.Image;
import pers.sherry.gof.bridge.abstraction.Brush;

/**
 * Refined Abstraction
 */
public class LargeBrush extends Brush {

    public LargeBrush(Color color) {
        super(color);
    }

    @Override
    public void paint(Image image) {
        System.out.println("Large brush paint " + mColor.getColor() + " " + image.getContent());
    }
}
