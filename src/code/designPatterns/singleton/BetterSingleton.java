package code.designPatterns.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @Classname BetterSinleton
 * @Description 双重校验加锁的单例模式（双重校验加锁+volatile）,考虑反射击穿单例(枚举创建单例可避免反射破解)
 * @Author codetulip
 * @Date 2019/10/23 23:17
 * @Version 1.0
 */
public class BetterSingleton {

    private static volatile BetterSingleton singleton = null;

    // 用以测试单例是否是线程安全的
    private static Set<Object> hashSet = Collections.synchronizedSet(new HashSet<>());

    // 单例模式
    private BetterSingleton() {
    }

    // 懒汉式获取单例（存在线程安全问题）
    public static BetterSingleton getInstance1() {
        if (singleton == null) {
            // 休眠，使测试效果更明显
            try {
                Thread.sleep(201);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new BetterSingleton();
            return singleton;
        }
        return singleton;
    }

    // 懒汉式获取单例synchronized
    public static synchronized BetterSingleton getInstance2() {
        if (singleton == null) {
            // 休眠，使测试效果更明显
            try {
                Thread.sleep(202);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new BetterSingleton();
            return singleton;
        }
        return singleton;
    }

    // 懒汉式获取单例双重加锁(看似线程安全，实际涉及到JMM指令重排，并不是线程安全的)
    // 双重加锁校验+BetterSingleton用volatile修饰 （推荐），volatile避免指令重排
    public static BetterSingleton getInstance3() {
        if (singleton == null) {
            // 休眠，使测试效果更明显
            try {
                Thread.sleep(203);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (BetterSingleton.class) {
                // 双重校验
                if (singleton == null) {
                    singleton = new BetterSingleton();
                    return singleton;
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1000);
        // 启动1000个线程测试单例模式是否安全
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    hashSet.add(getInstance1()); // getInstance1并不是线程安全的
//                    hashSet.add(getInstance2()); // 线程安全的，但是严重影响性能
//                    hashSet.add(getInstance3()); // 看似线程安全，实际上并不是线程安全，涉及JMM底层的指令重排
                    hashSet.add(BetterSingleton2.INSTANCE.getInstance()); // enum实现，线程安全且反射无效
                    latch.countDown();
                }
            }).start();
        }
        latch.await();
        System.out.println(hashSet.size());
    }

}
