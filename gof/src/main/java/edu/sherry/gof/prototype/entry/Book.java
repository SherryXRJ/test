package edu.sherry.gof.prototype.entry;

import java.util.List;

public class Book implements Cloneable {

    private Integer id;

    private String name;

    private float price;

    private List<Article> articleList;

    @Override
    public Book clone() throws CloneNotSupportedException {
        return (Book) super.clone();
    }

    //  Getter And Setter ...


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", articleList=" + articleList +
                '}';
    }
}


