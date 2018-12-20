package edu.sherry.gof.singleton;

import java.util.concurrent.ExecutionException;

public class TestSingleton {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println("Instance hashCode: " + LazySingletonPattern.getInstance().hashCode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
