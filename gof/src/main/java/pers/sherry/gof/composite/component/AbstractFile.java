package pers.sherry.gof.composite.component;

/**
 * component(抽象组件)
 */
public abstract class AbstractFile {

    protected String fileName;

    public AbstractFile(String fileName){
        this.fileName = fileName;
    }

    public abstract void add(AbstractFile file);

    public abstract void add(AbstractFile... files);

    public abstract void remove(AbstractFile file);

    public abstract AbstractFile get(int index);

    public abstract void operation();
}
