package code.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ThreadLocalVariableHolder
 * @Description 线程本地存储（防止共享资源冲突，自动为每个线程生成ThreadLocal变量）
 * @Author tujing
 * @Date 2019/5/28 11:43 PM
 * @Version 1.0
 */

class Accessor implements Runnable {

    private final int id;

    public Accessor(int idn) {
        id = idn;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
}

public class ThreadLocalVariableHolder {

    // ThreadLocal变量的创建方式(经常被当做静态域存储)
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random random = new Random(47);

        // 覆盖ThreadLocal方法
        @Override
        protected synchronized Integer initialValue() {
            return random.nextInt(10000);
        }
    };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get(); // 返回与线程相关联的副本
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Accessor(i)); // 实际上生成了5个value,即使只有一个ThreadLocal
        }
        TimeUnit.MILLISECONDS.sleep(100);
        executorService.shutdownNow();
        // 等待所有任务结束，如果任一任务在限时内未完成则返回false，如果所有任务在限时内完成则返回true
        if (executorService.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("some tasks were not terminated");
        }
    }
}
