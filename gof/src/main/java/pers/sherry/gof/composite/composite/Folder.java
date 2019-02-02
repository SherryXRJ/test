package pers.sherry.gof.composite.composite;

import pers.sherry.gof.composite.component.AbstractFile;

import java.util.LinkedList;
import java.util.List;

/**
 * composite (容器组件)
 */
public class Folder extends AbstractFile {

    private List<AbstractFile> files;

    public Folder(String fileName) {
        super(fileName);
        files = new LinkedList<>();
    }

    @Override
    public void add(AbstractFile file) {
        files.add(file);
    }

    @Override
    public void add(AbstractFile... files) {
        for (AbstractFile file : files) {
            this.add(file);
        }
    }

    @Override
    public void remove(AbstractFile file) {
        files.remove(file);
    }

    @Override
    public AbstractFile get(int index) {
        return files.get(index);
    }

    @Override
    public void operation() {
        files.forEach(AbstractFile::operation);
    }
}
