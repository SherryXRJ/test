package pers.sherry.gof.prototype;

import pers.sherry.gof.prototype.entry.Article;
import pers.sherry.gof.prototype.entry.Book;

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

        Book shallowCloneBook = book.clone();
        id = 2;
        shallowCloneBook.setId(id);
        list.add(new Article("ln"));
        shallowCloneBook.setArticleList(list);

        System.out.println("prototypeBook articleList hashCode : " + book.getArticleList().hashCode());
        System.out.println("shallowCloneBook  articleList hashCode : " + shallowCloneBook.getArticleList().hashCode());

    }

}
