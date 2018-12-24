package pers.sherry.gof.composite;

import pers.sherry.gof.composite.component.AbstractFile;
import pers.sherry.gof.composite.composite.Folder;
import pers.sherry.gof.composite.leaf.JpgFile;
import pers.sherry.gof.composite.leaf.TextFile;

/**
 * 8.组合模式 (树形结构操作)
 */
public class CompositePattern {

    public static void main(String[] args) {
        AbstractFile root = new Folder("root");             //  根路径
        AbstractFile imagePath = new Folder("image");       //  image路径
        AbstractFile txtPath = new Folder("txt");           //  txt路径

        AbstractFile imageA = new JpgFile("A.jpg");
        AbstractFile imageB = new JpgFile("B.jpg");
        AbstractFile imageC = new JpgFile("C.jpg");
        imagePath.add(imageA, imageB, imageC);

        AbstractFile txtA = new TextFile("A.txt");
        AbstractFile txtB = new TextFile("B.txt");
        AbstractFile txtC = new TextFile("C.txt");
        txtPath.add(txtA, txtB, txtC);

        AbstractFile config = new TextFile("config.txt");
        root.add(imagePath, txtPath, config);

        root.operation();
    }
}
