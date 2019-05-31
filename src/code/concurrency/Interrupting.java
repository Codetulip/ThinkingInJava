package code.concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Classname Interrupting
 * @Description 三种阻塞示例以及interrupt()用法(结合此类、CloseResource类和NIOInterruption类)
 * @Author tujing
 * @Date 2019/5/29 12:43 AM
 * @Version 1.0
 */

// 可中断的阻塞示例(sleep进入休眠)
class SleepBlocked implements Runnable {

    @Override
    public void run() {
        try {
            // 可被中断
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("exitint SleepBlocked.run()");
    }

}

// 等待IO输入而阻塞(不可中断的阻塞)
class IOBlocked implements Runnable {

    private InputStream in;

    public IOBlocked(InputStream is) {
        in = is;
    }

    @Override
    public void run() { // 实现Runnable接口出来的run（）方法没有返回值
        try {
            System.out.println("waiting for read()");
            in.read(); // 等待IO输入而阻塞，无法中断
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked IO");
            } else {
                throw new RuntimeException();
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

// 等待对象锁而阻塞(互斥阻塞)（不可中断的阻塞）
class SynchronizedBlocked implements Runnable {

    public synchronized void f() {
        // 永远不释放锁
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                f(); // 匿名线程最先获得了对象锁
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("trying to call f()");
        // 新创建的SynchronizedBlocked线程无法获得对象锁(对象锁被另外一个线程获得并且不释放)，所以这个将被阻塞
        f();
        System.out.println("exiting SynchronizedBlocked.run()"); // 不会执行,无法中断尝试获取对象锁
    }
}

public class Interrupting {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> f = executorService.submit(r); // 使用submit提交任务，返回线程相关的Future(持有该任务的上下文)
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("interrupting " + r.getClass().getName());
        f.cancel(true); // 取消正在执行的任务（如果任务还在执行）(对于io，无法中断)
        System.out.println("interrupt sent to " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception{
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("aborting with System.exit(0)");
        System.exit(0);
    }
}
