package code.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname EvenChecker
 * @Description
 * @Author tujing
 * @Date 2019/5/28 1:02 PM
 * @Version 1.0
 */
public class EvenChecker implements Runnable {

    private IntGenerator generator;

    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }


    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next(); // 这里调用next()方法的时机
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executorService.execute(new EvenChecker(gp, i));
        }
        executorService.shutdown();
    }

    // 重载，默认次数
    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
