package pers.sherry.juc.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class LargeTask extends RecursiveTask<Integer>{

    private static final int THRESHOLD = 10;

    private List<Integer> taskList;

    public LargeTask(List<Integer> list) {
        taskList = list;
    }

    @Override
    protected Integer compute() {
        //  切分
        if (taskList.size() > THRESHOLD) {
            LargeTask left = new LargeTask(taskList.subList(0, taskList.size() / 2));
            LargeTask right = new LargeTask(taskList.subList(taskList.size() / 2, taskList.size()));

            //  执行子任务
            left.fork();
            right.fork();
            return left.join() + right.join();
        } else {
            Integer sum = taskList.stream().reduce((i, j) -> i + j).get();
            System.out.println("Thread id: " + Thread.currentThread().getId());
            return sum;
        }
    }

}
