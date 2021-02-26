package com.code.tulip.thinking_in_java.concurrency.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Classname WaxOMatic
 * @Description 线程间的协作
 * @author code-tulip
 * @Date 2019/5/29 5:35 PM
 * @Version 1.0
 */

// 利用synchronized关键词获取对象锁完成协作
class Car {
    private boolean waxOn = false;

    // 涂蜡
    public synchronized void waxed() {
        waxOn = true; // 原子操作（安全的）
        notifyAll(); // 同步控制方法中使用
    }

    // 抛光（必须在涂蜡操作之后）
    public synchronized void buffed() {
        waxOn = false; // 准备好下一轮涂蜡
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        // 如果涂蜡完成了，就等待下次涂蜡，并释放锁让别的任务进来抛光
        while (waxOn == false) { // 感兴趣的特定条件
            wait(); // 等待并释放锁
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        // 如果涂蜡完成了，就等待下次涂蜡，并释放锁让别的任务进来抛光
        while (waxOn == true) {
            wait();
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

public class WaxOMatic {

    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 两个任务使用公共资源car
        executorService.execute(new WaxOn(car));
        executorService.execute(new WaxOff(car));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow(); // 中断所有任务
    }
}
