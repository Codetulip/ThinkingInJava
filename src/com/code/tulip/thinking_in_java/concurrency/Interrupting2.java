package com.code.tulip.thinking_in_java.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname Interrupting2
 * @Description 互斥阻塞的中断（ReentrantLock上阻塞的任务具备可以被中断的能力）
 * @author code-tulip
 * @Date 2019/5/29 2:51 PM
 * @Version 1.0
 */

// 阻塞可被中断(获得锁，但不释放锁，其他任务想要进入就会阻塞)
class BlockedMutex {
    private ReentrantLock lock = new ReentrantLock(); // 可重入的互斥锁

    public BlockedMutex() {
        lock.lock();
    }

    public void f() {
        try {
            // 永远都不会被第二个任务可用
            // 如果当前线程未被中断，则获得锁（在等待锁的过程中可以被中断,中断后直接异常不会获得锁即放弃等待）
            lock.lockInterruptibly();
            System.out.println("f()正在执行。。。。" + Thread.currentThread().getClass().getName()); // 不会输出
        } catch (InterruptedException e) {
            System.out.println("interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable {
    BlockedMutex blockedMutex = new BlockedMutex(); // 锁已经被其他线程获得了

    @Override
    public void run() {
        System.out.println("waiting for f() in BlockedMutex");
        blockedMutex.f(); // 将会等待锁
        System.out.println("Broken out of blocked call");
    }
}

public class Interrupting2 {

    public static void main(String[] args) throws Exception{
       /* ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Blocked2());*/
        Thread t = new Thread(new Blocked2(),"haha");
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt()");
        t.interrupt(); // 尽管不太可能，但是此处调用可能发生在blocked.f()之前
    }
}
