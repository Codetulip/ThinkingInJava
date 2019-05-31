package code.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname ExceptionThread
 * @Description 线程中的异常需要采取特殊步骤才能捕获
 * @Author tujing
 * @Date 2019/5/28 11:19 AM
 * @Version 1.0
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        // 即使将会产生异常的线程放入try/catch主体中也捕获不到
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new ExceptionThread());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
