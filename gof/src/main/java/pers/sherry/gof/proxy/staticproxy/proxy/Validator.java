package pers.sherry.gof.proxy.staticproxy.proxy;

public class Validator {

    public boolean validate(int userId) {
        return userId > 0 && userId < 10;
    }
}
