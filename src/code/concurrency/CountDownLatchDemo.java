/**
 * FileName: CountDownLatchDemo
 * Author:   Code
 * Date:     2019/1/28 16:38
 * Description: CountDownLatch
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.concurrency;


import java.util.Random;
<<<<<<< HEAD
import java.util.concurrent.*;
=======
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
>>>>>>> initial commit


// 某些需要先于waitingTask执行的任务
class TaskPortion implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private static Random random = new Random(47);

    private final CountDownLatch latch;

    TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            doWork();
            // 调用countDown()的线程不会被阻塞
            latch.countDown();
        } catch (InterruptedException e) {

        }
    }

    public void doWork() throws InterruptedException {
        // random.nextInt()碰巧是线程安全的
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
        System.out.println(this + "completed");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d ", id);
    }
}

// 等待TaskPortion全部执行完成后执行的任务
class WaitingTask implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // 调用await()的线程会被阻塞
            latch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d", id);
    }
}

public class CountDownLatchDemo {

    static final int SIZE = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 所有线程必须共享一个CountDownLatch
        CountDownLatch latch = new CountDownLatch(SIZE);
        // 即使先启动了WaitingTask，但是都不会执行，它们会等待TaskPortion全部执行完成后再执行
        for (int i = 0; i < 10; i++) {
            executorService.execute(new WaitingTask(latch));
        }

        for (int i = 0; i < SIZE; i++) {
            executorService.execute(new TaskPortion(latch));
        }

        System.out.println("launched all tasks...");

        executorService.shutdown();
    }
}
