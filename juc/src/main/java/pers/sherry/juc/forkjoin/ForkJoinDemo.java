package pers.sherry.juc.forkjoin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> task = forkJoinPool.submit(new LargeTask(list));
        System.out.println(task.get());

    }


}
