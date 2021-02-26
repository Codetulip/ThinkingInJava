package com.code.tulip.thinking_in_java.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname CriticalSection
 * @Description 临界区的使用(借助synchronized)
 * @author code-tulip
 * @Date 2019/5/28 10:23 PM
 * @Version 1.0
 */

// 非保护类型的类
class Pair { // 不是线程安全的
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equal: "  + Pair.this);
        }
    }

    // 两个变量必须相等
    public void checkState() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }
}

abstract class PairManager {

    AtomicInteger checkCounter = new AtomicInteger(0);

    protected Pair p = new Pair();

    // 生成同步容器
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }


    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {

        }
    }

    // synchronized不属于方法特征签名的部分，可以在覆盖方法时加上去
    // 模板设计方法
    public abstract void increment();

}

// 同步整个方法
class PairManager1 extends PairManager {

    // 同步整个方法
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

// 同步临界区
class PairManager2 extends PairManager {

    // 同步临界区
    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementY();
            p.incrementX();
            temp = getPair();
        }
        store(temp); // 容器是线程安全的，因此可以放在临界区外
    }
}

// 此线程的任务是调用PairManager完成x,y的值递增
class PairManipulator implements Runnable {

    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }


    @Override

    public void run() {
        while (true) {
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair: " + pm.getPair() + " checkCounter = " + pm.checkCounter.get();
    }
}

// 此线程的任务是检查x,y是否相等，并计算检查次数
class PairChecker implements Runnable {

    private PairManager pairManager;

    public PairChecker(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.checkCounter.incrementAndGet(); // 以原子方式使当前值加1
            // getPair()方法时同步的，所以可能需要等待对象锁，因此同步方法检查一次的时间更长
            pairManager.getPair().checkState(); // 检查x,y的值是否相等
        }
    }
}

public class CriticalSection {

    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        PairManipulator
                pm1 = new PairManipulator(pman1),
                pm2 = new PairManipulator(pman2);
        PairChecker
                pCheck1 = new PairChecker(pman1),
                pCheck2 = new PairChecker(pman2);
        executorService.execute(pm1);
        executorService.execute(pm2);
        executorService.execute(pCheck1);
        executorService.execute(pCheck2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }
        System.out.println("pm1: " + pm1 + "\n pm2: " + pm2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager
                pman1 = new PairManager1(),
                pman2 = new PairManager2();
        testApproaches(pman1, pman2);
    }
}
