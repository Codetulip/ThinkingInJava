package com.code.tulip.thinking_in_java.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Classname TestBlockingQueues
 * @Description 使用BlockingQueue（同步队列）解决线程协作问题
 * @author code-tulip
 * @Date 2019/5/29 9:44 PM
 * @Version 1.0
 */

// 消费者
class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }

    public void add(LiftOff liftOff) {
        try {
            // add()方法也可以添加，但是没有有用空间时将会异常。put()也是添加，但是会等待有用空间
            rockets.put(liftOff);  // 可被中断
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }

    // 可以忽略同步问题，因为已经由BlockingQueue解决了
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // take()和poll()方法都是取出，并且在元素可用前会一直等待，poll还可以指定等待时间,take()是可被中断的
                LiftOff rocket = rockets.take();
                rocket.run();  // 显示的调用run()方法，而不是为每个任务开启一个新线程
            }
        } catch (InterruptedException e) {
            System.out.println("waking from take()");
        }
        System.out.println("exiting LiftOffRunner");
    }
}

public class TestBlockingQueues {

    static void getKey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getKey(String message) {
        System.out.println(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start(); // 启动消费者
        // 放入消费的资源
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
        getKey("press 'Enter' (" +msg + ")");
        t.interrupt(); // 中断消费者
        System.out.println("finished " + msg + " test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>()); // 无界队列
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3)); // 固定尺寸队列，自己设置
        test("SynchronousQueue", new SynchronousQueue<LiftOff>()); // 尺寸为1
    }
}
