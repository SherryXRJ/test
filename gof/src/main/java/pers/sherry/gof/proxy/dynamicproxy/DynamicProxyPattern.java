package pers.sherry.gof.proxy.dynamicproxy;

import pers.sherry.gof.proxy.dynamicproxy.proxy.UserProxyHandler;
import pers.sherry.gof.proxy.dynamicproxy.real.UserImpl;
import pers.sherry.gof.proxy.dynamicproxy.subject.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 12.动态代理(Dynamic Proxy Patter)
 */
public class DynamicProxyPattern {

    public static void main(String[] args) {
        UserDao realDao = new UserImpl();   //  真实主题

        InvocationHandler handler = new UserProxyHandler(realDao);  //  handler处理器
        UserDao proxy       //  代理对象
                = (UserDao) Proxy.newProxyInstance(
                        realDao.getClass().getClassLoader(),
                        realDao.getClass().getInterfaces(),
                        handler);
        System.out.println("proxy : " + proxy.getClass().getName());    //  print:  {proxy : com.sun.proxy.$Proxy0}
        int userId = proxy.getUserId("Tom");
    }


}
