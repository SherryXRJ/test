package pers.sherry.gof.proxy.dynamicproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Proxy - 代理(动态)
 */
public class UserProxyHandler implements InvocationHandler {

    private Object subject;

    public UserProxyHandler(Object object) {
        subject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy == this);

        before(args);
        Object result = method.invoke(subject, args);   //  返回值
        System.out.println("result: " + result);
        after(method);
        return result;
    }

    private void before(Object[] args) {
        System.out.println("before invoke args[]" + Arrays.toString(args));
    }

    private void after(Method method) {
        System.out.println("after invoke " + method.getName() + " finished.");
    }
}
