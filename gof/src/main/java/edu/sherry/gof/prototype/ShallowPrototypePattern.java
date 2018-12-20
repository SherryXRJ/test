package edu.sherry.gof.prototype;

import edu.sherry.gof.prototype.entry.Article;
import edu.sherry.gof.prototype.entry.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * 4.原型模式 - 浅拷贝
 */
public class ShallowPrototypePattern {

    public static void main(String[] args) throws CloneNotSupportedException {
        Book book = new Book();
        Integer id = 1;
        book.setId(id);
        book.setName("Math Book");
        book.setPrice(21.8f);
        List<Article> list = new ArrayList<>();
        list.add(new Article("Function"));
        list.add(new Article("Algorithm"));
        book.setArticleList(list);

        Book shallowCloeBook = book.clone();
        id = 2;
        shallowCloeBook.setId(id);
        list.add(new Article("ln"));
        shallowCloeBook.setArticleList(list);
        System.out.println(book);
        System.out.println(shallowCloeBook);
    }

}
