package pers.sherry.gof.bridge;

import pers.sherry.gof.bridge.abstraction.Brush;
import pers.sherry.gof.bridge.implementor.Color;
import pers.sherry.gof.bridge.refined.LargeBrush;
import pers.sherry.gof.util.Dom4jUtil;

/**
 * 7.桥接模式 (对维度进行解耦)
 */
public class BridgePattern {

    public static void main(String[] args){
        Color color = (Color) Dom4jUtil.getBean("color");
    }
}
