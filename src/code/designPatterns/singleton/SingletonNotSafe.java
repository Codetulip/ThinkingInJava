package code.designPatterns.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname SingletonNotSafe
 * @Description 线程不安全的单例
 * @Author tujing
 * @Date 2019/6/7 10:28 PM
 * @Version 1.0
 */
public class SingletonNotSafe {

    private static SingletonNotSafe singletonNotSafe = null; // 懒汉式

    // 限制产生多个对象
    private SingletonNotSafe() {

    }

    // 使用以下方法获得实例对象
    public static SingletonNotSafe getSingletonNotSafe() {
        if (singletonNotSafe == null) { // 线程不安全的地方
            singletonNotSafe = new SingletonNotSafe();
            return singletonNotSafe;
        }
        return singletonNotSafe;
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            // 启动多个线程获取SingletonNotSafe对象进行测试
            // 此测试效果并不理想，可自行理解如何不安全
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    // 获取SingletonNotSafe对象
                    SingletonNotSafe singletonNotSafe = SingletonNotSafe.getSingletonNotSafe();
                    System.out.println(singletonNotSafe);
                }
            });
        }
    }
}
