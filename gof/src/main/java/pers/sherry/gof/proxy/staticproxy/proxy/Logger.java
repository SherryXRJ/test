package pers.sherry.gof.proxy.staticproxy.proxy;

public class Logger {

    public void log(int userId, String keyword){
        System.out.println("userId:" + userId + " search: " + keyword);
    }
}
