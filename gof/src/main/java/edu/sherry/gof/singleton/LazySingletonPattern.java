package edu.sherry.gof.singleton;

/**
 * 5.单例模式 - 双重校验锁
 */
public class LazySingletonPattern {

    private volatile static LazySingletonPattern instance;

    private LazySingletonPattern() throws InterruptedException {
        //  模拟耗时操作
        Thread.sleep(3000);
    }

    public static LazySingletonPattern getInstance() throws InterruptedException {
        if (instance == null) {
            synchronized (LazySingletonPattern.class) {
                if (instance == null) {
                    instance = new LazySingletonPattern();
                }
            }
        }
        return instance;
    }
}
