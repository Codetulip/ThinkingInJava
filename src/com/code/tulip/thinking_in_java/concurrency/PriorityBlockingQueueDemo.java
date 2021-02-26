package com.code.tulip.thinking_in_java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Classname PriorityBlockingQueueDemo
 * @Description PriorityBlockingQueue的示例
 * @author code-tulip
 * @Date 2019/5/30 10:31 AM
 * @Version 1.0
 */

// 优先级任务
class PrioritiedTask implements Runnable, Comparable<PrioritiedTask>{

    private Random random = new Random(47);

    private static int counter = 0;

    private final int id = counter++;

    private final int priority;

    protected static List<PrioritiedTask> sequence = new ArrayList<PrioritiedTask>();

    public PrioritiedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(250));
        } catch (InterruptedException e) {

        }
        System.out.println(this);
    }

    @Override
    public int compareTo(PrioritiedTask o) {
        if (priority < o.priority) {
            return -1;
        } else if (priority  == o.priority) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return String.format("[%1$-3d]", priority) + " Task " + id;
    }

    public String summary() {
        return "(" + id + ":" + priority + ")";
    }

    // 终止任务
    public static class EndSentinel extends PrioritiedTask {

        private ExecutorService executorService;

        public EndSentinel(ExecutorService e) {
            super(-1); // 最低的优先级，保证最后执行
            executorService = e;
        }

        @Override
        public void run() {
            int count = 0;
            for (PrioritiedTask p : sequence) {
                System.out.print(p.summary());
                if (++count % 5 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            executorService.shutdownNow();
        }
    }
}

// 优先级任务生产者
class PrioritiedTaskProducer implements Runnable {

    private Random random = new Random(47);

    private Queue<Runnable> queue;

    private ExecutorService executorService;

    public PrioritiedTaskProducer(Queue<Runnable> q, ExecutorService e) {
        queue = q;
        executorService = e;
    }

    @Override
    public void run() {
        // 使用无界阻塞队列，快速加入20个随机优先级的任务
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritiedTask(random.nextInt(10)));
            Thread.yield();
        }

        try {
            // 添加10个最高优先级的任务
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritiedTask(10));
            }
            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritiedTask(i));
            }
            queue.add(new PrioritiedTask.EndSentinel(executorService));
        } catch (InterruptedException e) {

        }
        System.out.println("Finished PrioritiedTaskProducer!");
    }
}

class PriorotiedTaskConsumer implements Runnable {

    private PriorityBlockingQueue<Runnable> queue; // 泛型，增加了代码的复用性

    public PriorotiedTaskConsumer(PriorityBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 利用当前线程运行任务
                queue.take().run();
            }
        } catch (InterruptedException e) {

        }
        System.out.println("Finished PriorotiedTaskConsumer");
    }
}

public class PriorityBlockingQueueDemo {

    public static void main(String[] args) {
        Random random = new Random(47);
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<Runnable>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new PrioritiedTaskProducer(queue, executorService));
        executorService.execute(new PriorotiedTaskConsumer(queue));
    }
}
