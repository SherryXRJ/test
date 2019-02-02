package pers.sherry.gof.prototype.entry;

import java.io.Serializable;

public class Attachment implements Serializable{

    private String fileName;

    public Attachment(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
