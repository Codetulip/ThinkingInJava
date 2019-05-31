package code.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname AttemptLocking
 * @Description
 * @Author tujing
 * @Date 2019/5/28 4:01 PM
 * @Version 1.0
 */

// 显示的使用Lock提供了更细粒度的控制力
public class AttemptLocking {

    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock(); // 尝试获取锁，获取到了返回true，并可以设定尝试时间

        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // true，获取锁然后释放锁
        al.timed(); // true，获取锁然后释放锁
        new Thread() {
            { setDaemon(true); }
            public void run() {
                al.lock.lock(); // 获取锁，但是没有释放锁
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();
        al.untimed();
        al.timed();
    }
}
