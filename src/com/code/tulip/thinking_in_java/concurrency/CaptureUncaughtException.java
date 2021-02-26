package com.code.tulip.thinking_in_java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Classname CaptureUncaughtException
 * @Description 捕获线程产生的异常
 * @author code-tulip
 * @Date 2019/5/28 11:32 AM
 * @Version 1.0
 */

// 产生异常的线程
class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

// 创建未捕获异常的处理器
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

// 更改Executors创建线程的方式
class HandlerThreadFactory implements ThreadFactory {

    // 创建线程的过程
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        // 将未捕获异常处理器附在此线程上
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());

        return t;
    }
}

public class CaptureUncaughtException {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(new HandlerThreadFactory()); // 指定线程产生的方式
        executorService.execute(new ExceptionThread2());

        /**
         * 捕获异常时，还会利用ExecutorService产生一个线程，并创建了新的Thread.UncaughtExceptionHandler
         * 具体情况未知
         */
    }
}
