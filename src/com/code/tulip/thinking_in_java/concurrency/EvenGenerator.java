package com.code.tulip.thinking_in_java.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname EvenGenerator
 * @Description
 * @author code-tulip
 * @Date 2019/5/28 1:36 PM
 * @Version 1.0
 */


// 显示的使用Lock对象
class MutexEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    private Lock lock = new ReentrantLock(); // Lock对象必须被显示的创建、锁定和释放
    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();  // 加快失败的出现
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();  // 无论怎么样锁都要被释放
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}


public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    // 使用synchronized
    @Override
    public /*synchronized */int next() {
        ++currentEvenValue;  // 危险点（其他的EvenChecker可能在这里就调用了next(),那么currentEvenValue值就处于不恰当的状态）
        ++currentEvenValue;  // 递增不是原子性的操作
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
