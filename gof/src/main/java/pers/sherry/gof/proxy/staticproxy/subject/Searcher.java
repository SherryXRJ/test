package pers.sherry.gof.proxy.staticproxy.subject;

/**
 * Subject - 抽象主题
 */
public interface Searcher {

    String search(int userId, String keyword);

}
