package code.concurrency;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Classname ActiveObjectDemo
 * @Description 活动对象或行动者
 * @Author tujing
 * @Date 2019/5/30 10:30 PM
 * @Version 1.0
 */
public class ActiveObjectDemo {

    private ExecutorService executorService = Executors.newSingleThreadExecutor(); // 单线程执行器（无界阻塞队列）

    private Random random = new Random(47);

    // 休眠
    public void pause(int pause) {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(pause));
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    // 整数计算
    public Future<Integer> caculateInt(int x, int y) {
        return executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("starting " + x + " + " + y);
                pause(50);
                return x + y;
            }
        });
    }

    // 浮点数计算
    public Future<Float> caculateFloat(float x, float y) {
        return executorService.submit(new Callable<Float>() {
            @Override
            public Float call() throws Exception {
                System.out.println("starting " + x + " + " + y);
                pause(200);
                return x + y;
            }
        });
    }

    // 关闭线程
    public void shutdown() {
        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        ActiveObjectDemo activeObjectDemo = new ActiveObjectDemo();
        // 避免ConcurrentModificationException
        List<Future<?>> results = new CopyOnWriteArrayList<Future<?>>();
        for (float f = 0.0f; f < 1.0f; f += 0.2f) {
            results.add(activeObjectDemo.caculateFloat(f, f));
        }
        for (int i = 0; i < 5; i++) {
            results.add(activeObjectDemo.caculateInt(i, i));
        }
        System.out.println("All asynch calls made");
//        TimeUnit.SECONDS.sleep(5);
        // 由于方法调用在单线程执行器内部排队，同步控制在消息级别上
        while (results.size() > 0) {
            for (Future<?> f : results) {
                if (f.isDone()) {
                    try {
                        System.out.println(f.get());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    results.remove(f); // 由于是CopyOnWriteArrayList因此不会抛出ConcurrentModificationException
                }
            }
        }
        activeObjectDemo.shutdown();
    }
}
