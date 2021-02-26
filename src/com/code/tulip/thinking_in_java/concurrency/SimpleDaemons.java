package com.code.tulip.thinking_in_java.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @Classname SimpleDaemons
 * @Description 后台线程（守护线程）
 * @author code-tulip
 * @Date 2019/5/27 3:33 PM
 * @Version 1.0
 */
// 如果一个线程是后台线程，那么它创建的任何线程都将自动设置成后台线程
public class SimpleDaemons implements Runnable{

    // 后台进程在不执行finally的情况下就会终止run()方法
    // 注释掉setDaemon()方法才会执行finally
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        } finally {
            System.out.println("This should always run?");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // 设置为后台进程，而且必须在start()之前调用
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175); // 主线程结束后，所有的后台线程都会被杀死，因此这里需要休眠下，不然只能看到部分后台进程的结果
    }
}
