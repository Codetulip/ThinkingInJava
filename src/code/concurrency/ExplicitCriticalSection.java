package code.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname ExplicitCriticalSection
 * @Description 临界区的使用（借助Lock）
 * @Author tujing
 * @Date 2019/5/28 11:16 PM
 * @Version 1.0
 */

// 锁整个方法
class ExplicitPairManager1 extends PairManager {

    private Lock lock = new ReentrantLock();

    @Override
    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}

// 锁临界区
class ExplicitPairManager2 extends PairManager {

    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        Pair temp;
        // 临界区
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}
public class ExplicitCriticalSection {

    public static void main(String[] args) {
        PairManager
                pman1 = new ExplicitPairManager1(),
                pman2 = new ExplicitPairManager2();
        // 这次会抛出异常，但是x、y确实相等的
        // PairValuesNotEqualException: Pair values not equal: x: 2, y: 1
        CriticalSection.testApproaches(pman1, pman2);
    }
}
