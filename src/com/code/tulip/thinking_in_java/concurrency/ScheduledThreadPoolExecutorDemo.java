package com.code.tulip.thinking_in_java.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @Classname ScheduledThreadPoolExecutorDemo
 * @Description ScheduledThreadPoolExecutor类的简单示例
 * @author code-tulip
 * @Date 2019/5/30 12:07 PM
 * @Version 1.0
 */
public class ScheduledThreadPoolExecutorDemo {

    ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);

    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    // 指定延迟后任务开始
    public void schedule(Runnable event, long delay) {
        ScheduledFuture<?> schedule = scheduler.schedule(event, delay, TimeUnit.SECONDS);
//        executorService.schedule(event, delay, TimeUnit.SECONDS);
    }

    // 指定延迟后任务开始，并每隔一段时间都执行
    public void repeat(Runnable event, long initialDealy, long period) {
        scheduler.scheduleAtFixedRate(event, initialDealy, period, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        ScheduledThreadPoolExecutorDemo scheduledThreadPoolExecutorDemo = new ScheduledThreadPoolExecutorDemo();
        scheduledThreadPoolExecutorDemo.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("指定延迟后开始执行...");
            }
        }, 5);
        scheduledThreadPoolExecutorDemo.repeat(new Runnable() {
            @Override
            public void run() {
                System.out.println("指定延迟后开始循环执行...");
            }
        }, 1000, 500);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer.schedule...");
        }
        }, 2000);
    }

}
