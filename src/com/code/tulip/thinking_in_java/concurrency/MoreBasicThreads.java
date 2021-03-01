package com.code.tulip.thinking_in_java.concurrency;

/**
 * @Classname MoreBasicThreads
 * @Description 多个LiftOff一起测试
 * @author code-tulip
 * @Date 2019/5/27 2:31 PM
 * @Version 1.0
 */
public class MoreBasicThreads {

    public static void main(String[] args) {
        // 你会看到线程交替运行的现象
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting for LiftOff");
    }
}
