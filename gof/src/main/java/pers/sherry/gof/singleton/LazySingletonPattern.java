package pers.sherry.gof.singleton;

/**
 * 5.单例模式 - 双重校验锁
 */
public class LazySingletonPattern {

    private static LazySingletonPattern instance;

    private LazySingletonPattern() {}

    public static LazySingletonPattern getInstance() throws InterruptedException {
        if (instance == null) {
            synchronized (LazySingletonPattern.class) {
                if (instance == null) {
                    //  模拟耗时操作
                    Thread.sleep(3000);
                    instance = new LazySingletonPattern();
                }
            }
        }
        return instance;
    }
}
