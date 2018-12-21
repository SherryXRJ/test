package pers.sherry.gof.bridge;

/**
 * 实体
 */
public class Image {

    public Image() {
    }

    public Image(String content) {
        this.content = content;
    }

    String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
