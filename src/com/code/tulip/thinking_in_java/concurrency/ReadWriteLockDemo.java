package com.code.tulip.thinking_in_java.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Classname ReadWriteLockDemo
 * @Description ReadWriteLock(接口)的示例
 * @author code-tulip
 * @Date 2019/5/30 9:35 PM
 * @Version 1.0
 */
public class ReadWriteLockDemo<T> {

    private ArrayList<T> lockedList;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true); // 参数为公平策略

    public ReadWriteLockDemo(int size, T iniialValue) {
        lockedList = new ArrayList<T>(Collections.nCopies(size, iniialValue)); // 数量为size的T对象（完全一样）
    }

    // 写操作
    public T set(int index, T element) {
        Lock wlock = lock.writeLock(); // 写的锁
        wlock.lock();
        try {
            return lockedList.set(index, element);
        } finally {
            wlock.unlock();
        }
    }

    // 读操作
    public T get(int index) {
        Lock rlock = lock.readLock(); // 读的锁
        rlock.lock();
        try {
            if (lock.getReadLockCount() > 1) {
                System.out.print(lock.getReadLockCount() + " "); // 返回正在读的任务数量
            }
            return lockedList.get(index);
        } finally {
            rlock.unlock();
        }
    }

    public static void main(String[] args) {
        new ReaderWriterListTest(30, 1);
    }

}

class ReaderWriterListTest {

    ExecutorService executorService = Executors.newCachedThreadPool();

    private final static int SIZE = 100;

    private static Random random = new Random(47);

    private ReadWriteLockDemo<Integer> list = new ReadWriteLockDemo<>(SIZE, 0);

    // 写线程
    private class Writer implements Runnable {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 20; i++) {
                    list.set(i, random.nextInt());
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e) {

            }
            System.out.println("Writer finished, shutting down");
            executorService.shutdownNow();
        }
    }

    // 读线程
    private class Reader implements Runnable {


        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    for (int i = 0; i < SIZE; i++) {
                        list.get(i);
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                }
            } catch (InterruptedException e) {

            }
        }
    }

    public ReaderWriterListTest(int readers, int writers) {
        for (int i = 0; i < readers; i++) {
            executorService.execute(new Reader());
        }
        for (int i = 0; i < writers; i++) {
            executorService.execute(new Writer());
        }
    }
}

