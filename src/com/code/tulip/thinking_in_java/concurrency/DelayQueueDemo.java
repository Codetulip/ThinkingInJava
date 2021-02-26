package com.code.tulip.thinking_in_java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @Classname DelayQueueDemo
 * @Description DelayQueue的示例
 * @author code-tulip
 * @Date 2019/5/30 12:27 AM
 * @Version 1.0
 */

// Delayed接口用来标记那些应该在给定延迟后执行的任务
class DelayTask implements Runnable, Delayed {

    private static int counter = 0;

    private final int id = counter++;

    private final long trigger; // 任务具体到期时间

    private final int delta; // 延迟时间

    private static List<DelayTask> sequence = new ArrayList<DelayTask>(); // 用于存放DelayTask

    public DelayTask(int delta) {
        this.delta = delta;
        trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS); // 将毫秒转化为纳秒
        sequence.add(this);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert((trigger - System.nanoTime()), NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayTask other = (DelayTask) o;
        if (trigger < other.trigger) {
            return -1;
        } else if(trigger == other.trigger) {
            return 0;
        } else {
            return 1;
        }

    }

    @Override
    public void run() {
        System.out.println(" " + this);
    }

    @Override
    public String toString() {
        return String.format("[%1$-4d]", delta) + "task " + id;
    }

    public String summary() {
        return "(" + id + ":" + delta + ")";
    }

    // 结束所有的任务
    public static class EndSentinel extends DelayTask {

        private ExecutorService executorService;

        public EndSentinel(int delta, ExecutorService e) {
            super(delta);
            executorService = e;
        }

        @Override
        public void run() {
            for (DelayTask pt : sequence) { // sequence保持了插入顺序
                System.out.println(pt.summary() + " "); // 观察任务的插入顺序
            }
            System.out.println();
            System.out.println(this + " calling shutdownNow()");
            executorService.shutdownNow();
        }
    }
}

class DelayedTaskConsumer implements Runnable {

    private DelayQueue<DelayTask> q; // 对象只有到期了才能被取走，队头对象为到期后存放时间最长的

    public DelayedTaskConsumer(DelayQueue<DelayTask> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                q.take().run(); // 利用本线程运行任务(可以观察到任务的执行顺序)
            }
        } catch (InterruptedException e) {

        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}

public class DelayQueueDemo {

    public static void main(String[] args) {
        Random rand = new Random(47);
        DelayQueue<DelayTask> q = new DelayQueue<DelayTask>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 创建延迟任务
        for (int i = 0; i < 20; i++) {
            q.put(new DelayTask(rand.nextInt(5000)));
        }
        q.add(new DelayTask.EndSentinel(5000, executorService)); // 负责最后输出所有的任务并终止(如果有任务还在执行的话)
        executorService.execute(new DelayedTaskConsumer(q)); // 输出任务的插入顺序（可以观察任务的执行执行）
        // 任务创建的顺序对执行顺序没有影响，任务按照期望的延迟时间后执行
    }
}
