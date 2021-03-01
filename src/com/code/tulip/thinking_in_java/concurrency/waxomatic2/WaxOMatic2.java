package com.code.tulip.thinking_in_java.concurrency.waxomatic2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname WaxOMatic2
 * @Description 使用Condition类的await()和signal()方法完成线程协作(signalAll()是更安全的方式)
 * @author code-tulip
 * @Date 2019/5/29 8:58 PM
 * @Version 1.0
 */

// 使用Lock和Condition对象获取锁完成线程协作
class Car {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition(); // 绑定lock的Condition实例

    private boolean waxOn = false;

    public void waxed() {
        lock.lock();
        try {
            waxOn = true; // 涂蜡完成了，等待抛光
            condition.signalAll(); // 唤醒
        } finally {
            lock.unlock();
        }
    }

    public void buffed() {
        lock.lock();
        try {
            waxOn = false; // 抛光完成了，等待涂蜡
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    // 抛光之后等待涂蜡
    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == false) {
                condition.await(); // 与此Condition相关的锁以原子方式释放
            }
        } finally {
            lock.unlock();
        }
    }

    // 涂蜡之后等待抛光
    public void waitForBuffing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == true) {
                condition.await(); // 与此Condition相关的锁以原子方式释放
            }
        } finally {
            lock.unlock();
        }
    }
}

// 负责涂蜡的线程
class WaxOn implements Runnable {

    private Car car;


    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax On");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed(); // 完成本次涂蜡任务，并唤醒抛光线程
                car.waitForBuffing(); // 等待抛光任务的完成
            }
        } catch (InterruptedException e) {
            System.out.println("exiting via interrupt");
        }
        System.out.println("ending wax on task");
    }
}

// 负责抛光的线程
class WaxOff implements Runnable {

    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing(); // 查看涂蜡任务是否已经完成
                System.out.println("wax off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("exiting via interrupt");
        }
        System.out.println("ending wax off task");

    }
}

public class WaxOMatic2 {

    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new WaxOff(car));
        executorService.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}
