package code.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname CachedThreadPool
 * @Description 使用Executor管理线程
 * @Author tujing
 * @Date 2019/5/27 2:40 PM
 * @Version 1.0
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(); // 创建一个线程池,合理的首选
//        ExecutorService executorService = Executors.newFixedThreadPool(5); //指定线程池大小，限制线程的数量,以共享的无界队列运行这些线程
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
