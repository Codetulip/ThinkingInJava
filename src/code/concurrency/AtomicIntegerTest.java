package code.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname AtomicIntegerTest
 * @Description 使用AtomicInteger替代int
 * @Author tujing
 * @Date 2019/5/28 9:58 PM
 * @Version 1.0
 */

// 利用原子类消除了synchronized
// 原子类很少使用，在涉及性能调优时用处比较多
public class AtomicIntegerTest implements Runnable {

    private AtomicInteger i = new AtomicInteger(0);

    public int getValue() {
        return i.get();
    }

    public void evenIncrement() {
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        // 创建定时任务，后台任务
        // schedule()指定任务，可以指定多久后执行，和周期性
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        System.err.println("Aborting");
                        System.exit(0);
                    }
                }, 5000);

        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicIntegerTest at = new AtomicIntegerTest();
        executorService.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
