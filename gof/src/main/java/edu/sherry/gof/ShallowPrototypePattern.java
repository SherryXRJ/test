package edu.sherry.gof;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * 4.原型模式 - 浅拷贝
 */
public class ShallowPrototypePattern {

    public static void main(String[] args) throws CloneNotSupportedException {
        Book book = new Book();
        book.setName("Math Book");
        book.setPrice(21.8f);
        book.setArticleList(Arrays.asList(new Article("Function"), new Article("Algorithm")));

        Book shallowCloeBook = book.clone();
        System.out.println("shallowCloeBook : " + shallowCloeBook.getPrice());

        shallowCloeBook.setPrice(99.0f);
        System.out.println(book.getPrice());
    }

    static class Article {

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
    }

    static class Book implements Cloneable{

        private String name;

        private float price;

        private List<Article> articleList;

        @Override
        protected Book clone() throws CloneNotSupportedException {
            return (Book) super.clone();
        }

        //  Getter And Setter ...

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
    }
}
