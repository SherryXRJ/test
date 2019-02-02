package pers.sherry.gof.proxy.dynamicproxy.real;

import pers.sherry.gof.proxy.dynamicproxy.subject.UserDao;

import java.util.Random;

/**
 * Real Subject 具体主题实现
 */
public class UserImpl implements UserDao {

    @Override
    public int getUserId(String name) {
        return new Random().nextInt();
    }
}
