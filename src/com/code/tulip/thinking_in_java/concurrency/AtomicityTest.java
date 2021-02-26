package com.code.tulip.thinking_in_java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname AtomicityTest
 * @Description 原子性的部分测试
 * @author code-tulip
 * @Date 2019/5/28 8:48 PM
 * @Version 1.0
 */
public class AtomicityTest implements Runnable{

    private int i = 0;  // 唯一可变的域，使用volatile是安全的

    // get并不是synchronized
    public int getValue() {
        return i;
    }

    // 看起来像是保证了i肯定是偶数
    private synchronized void evenIncrement() {
        ++i;
        ++i;
    }


    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        executorService.execute(at);
        while (true) {
            int val = at.getValue(); // 这个方法并不是同步的，因此还是可能取到非稳定状态的i
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }

}
