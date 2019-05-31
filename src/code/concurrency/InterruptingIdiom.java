package code.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @Classname InterruptingIdiom
 * @Description 检查中断的惯用法(需要被清理的对象创建操作后，必须紧跟try-finally块确保被清理)
 * @Author tujing
 * @Date 2019/5/29 3:18 PM
 * @Version 1.0
 */
class NeedsCleanup {

    private final int id;

    public NeedsCleanup(int ident) {
        id = ident;
    }

    public void cleanup() {
        System.out.println("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable {

    private volatile double d = 0.0; // 保持可见性（直接写入主存）

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) { // 检查中断状态
                // pointer1
                NeedsCleanup n1 = new NeedsCleanup(1);
                // 定义后马上开始try-finally模块，确保合适的cleanup()，经由异常离开循环后正确清理资源的必要性
                try {
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    // pointer2
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    // 确定合适的cleanup
                    try {
                        System.out.println("calculating");
                        // 消耗时间的非阻塞操作
                        for (int i = 1; i < 250000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        System.out.println("finished time-consuming operation");
                    } finally {
                        n2.cleanup(); // 确保被清理
                    }
                } finally {
                    n1.cleanup(); // 确保被清理
                }
            }
            System.out.println("exiting via while() test");
        } catch (InterruptedException e) {
            System.out.println("exiting via InterruptedException");
        }
    }
}

public class InterruptingIdiom {

    public static void main(String[] args) throws Exception{
        /*if (args.length != 1) {
            System.out.println("usage: java InterruptingIdiom delay-in-mS");
            System.exit(1);
        }*/
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(10000));
        t.interrupt();
    }
}
