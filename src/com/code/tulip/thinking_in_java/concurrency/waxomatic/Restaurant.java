package com.code.tulip.thinking_in_java.concurrency.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Classname Restaurant
 * @Description 生产者与消费者
 * @author code-tulip
 * @Date 2019/5/29 7:22 PM
 * @Version 1.0
 */

// 被生产和消费的共享资源
class Meal {
    private final int orderNum;

    public Meal(int id) {
        orderNum = id;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}

// 消费者
class WaitPerson implements Runnable {

    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    // 防止信号丢失
                    while (restaurant.meal == null) {
                        wait(); // 可被中断
                    }
                }
                System.out.println("waitPersong got " + restaurant.meal);
                // 取到食物后，告知厨师食物没了，并且唤醒其线程
                synchronized (restaurant.chef) { // 此刻chef调用了wait方法，释放了对象锁，这里是可以获得的
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // 并在chef上调用notifyAll唤醒线程
                }
            }
        } catch (InterruptedException e) {
            System.out.println("waitperson interrupted");
        }
    }
}

// 生产者
class Chef implements Runnable {

    private Restaurant restaurant;

    private int count = 0; // 食物计数

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    // 防止信号丢失
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                if (++count == 10) {
                    System.out.println("out of food, closing");
                    restaurant.executorService.shutdownNow(); // 发出中断信号，直到遇到可中断的阻塞操作时抛出异常而退出(否则返回到循环顶部后退出)
                }
                System.out.println("order up");
                synchronized (restaurant.waitPerson) {// 此刻waitPerson调用了wait方法，释放了对象锁，这里是可以获得的
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();// 并在waitPerson上调用notifyAll唤醒线程
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("chef interrupted");
        }
    }
}


public class Restaurant {

    Meal meal;

    ExecutorService executorService = Executors.newCachedThreadPool();

    WaitPerson waitPerson = new WaitPerson(this);

    Chef chef = new Chef(this);

    public Restaurant() {
        executorService.execute(chef);
        executorService.execute(waitPerson);
    }


    public static void main(String[] args) {
        new Restaurant();
    }
}
