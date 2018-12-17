package edu.sherry.gof.prototype.entry;

public class Article {

    private String content;

    public Article(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "content='" + content + '\'' +
                '}';
    }
}
