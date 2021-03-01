package com.code.tulip.thinking_in_java.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ToastOMatic
 * @Description BlockingQueue示例
 * @author code-tulip
 * @Date 2019/5/29 10:29 PM
 * @Version 1.0
 */


// 消费的资源
class Toast {
    public enum Status {
        DRY, BUTTERED, JAMMED
    }

    private Status status = Status.DRY;

    private final int id;

    public Toast(int ident) {
        id = ident;
    }

    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast>{}


// 负责生产吐司的任务
class Toaster implements Runnable {

    private ToastQueue toastQueue;

    public Toaster(ToastQueue tq) {
        toastQueue = tq;
    }

    private int count = 0;

    private Random random = new Random(47);

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500)); // 生产的太快难以观察到效果
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toastQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("toaster interrupted");
        }
        System.out.println("Toaster off");
    }
}

// 负责涂抹黄油的任务
class Butterer implements Runnable {

    private ToastQueue dryQueue, butterQueue; // 分别存放了需要涂抹黄油和涂抹酱的吐司

    public Butterer(ToastQueue dq, ToastQueue bq) {
        dryQueue = dq;
        butterQueue = bq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 一直等待，直到有可用的吐司
                Toast t = dryQueue.take();
                t.butter();
                System.out.println(t);
                butterQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer interrupted");
        }
        System.out.println("Butterer off");
    }
}

class Jammer implements Runnable {

    private ToastQueue butterQueue, finishedQueue; // 分别存放了需要涂抹酱的吐司和已完成的吐司


    public Jammer(ToastQueue bq, ToastQueue fq) {
        butterQueue = bq;
        finishedQueue = fq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 一直等待，直到有可用的吐司
                Toast t = butterQueue.take();
                t.jam();
                System.out.println(t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer off");
    }
}

// 消费吐司的任务
class Eater implements Runnable {

    private ToastQueue finishedQueue;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    private int counter = 0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = finishedQueue.take();
                // 确定吐司有序的放在队列中，并且所有的环节都弄好了
                if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>> Error: " + t);
                    System.exit(1);
                } else {
                    System.out.println("Chomp! " + t);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted");
        }
        System.out.println("Eater off");
    }
}

public class ToastOMatic {

    public static void main(String[] args) throws Exception {

        ToastQueue
                dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Toaster(dryQueue));
        executorService.execute(new Butterer(dryQueue, butteredQueue));
        executorService.execute(new Jammer(butteredQueue, finishedQueue));
        executorService.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}
