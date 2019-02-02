package pers.sherry.gof.proxy.staticproxy.proxy;

import pers.sherry.gof.proxy.staticproxy.real.RealSearcher;
import pers.sherry.gof.proxy.staticproxy.subject.Searcher;

/**
 * Proxy - 代理对象
 */
public class ProxySearcher implements Searcher{

    private Searcher mSearch = new RealSearcher();

    private Validator mValidator = new Validator();

    private Logger mLogger = new Logger();


    @Override
    public String search(int userId, String keyword) {
        if (mValidator.validate(userId)) {
            String result = mSearch.search(userId, keyword);
            mLogger.log(userId, keyword);
            return result;
        } else {
            return null;
        }
    }

}
