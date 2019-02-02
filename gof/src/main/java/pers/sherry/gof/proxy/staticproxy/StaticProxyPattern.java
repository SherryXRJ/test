package pers.sherry.gof.proxy.staticproxy;

import pers.sherry.gof.proxy.staticproxy.subject.Searcher;
import pers.sherry.gof.util.Dom4jUtil;

/**
 * 12.静态代理模式(Static Proxy Pattern)
 */
public class StaticProxyPattern {

    public static void main(String[] args) {

        Searcher searcher = (Searcher) Dom4jUtil.getBean("staticProxy");
        System.out.println(searcher.search(1, "1"));
        System.out.println(searcher.search(99, "99"));
    }
}
