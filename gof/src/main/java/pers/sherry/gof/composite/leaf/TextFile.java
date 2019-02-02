package pers.sherry.gof.composite.leaf;

import pers.sherry.gof.composite.component.AbstractFile;

/**
 * Leaf (叶子组件)
 * <p> 只支持业务操作
 */
public class TextFile extends AbstractFile {

    public TextFile(String fileName) {
        super(fileName);
    }

    @Override
    public void add(AbstractFile file) {
        throw new RuntimeException("unsupported");

    }

    @Override
    public void add(AbstractFile... files) {
        throw new RuntimeException("unsupported");
    }

    @Override
    public void remove(AbstractFile file) {
        throw new RuntimeException("unsupported");

    }

    @Override
    public AbstractFile get(int index) {
        throw new RuntimeException("unsupported");
    }

    @Override
    public void operation() {
        System.out.println(fileName + " TEXT operate...");

    }
}
