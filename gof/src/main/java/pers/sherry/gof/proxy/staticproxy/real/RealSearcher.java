package pers.sherry.gof.proxy.staticproxy.real;

import pers.sherry.gof.proxy.staticproxy.subject.Searcher;

/**
 * Real Subject - 真实主题
 */
public class RealSearcher implements Searcher{

    @Override
    public String search(int userId, String keyword) {
        return "keyword: " + keyword + " result: " + Math.random();
    }
}
