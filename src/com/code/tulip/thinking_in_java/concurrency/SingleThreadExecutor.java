package com.code.tulip.thinking_in_java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname SingleThreadExecutor
 * @Description SingleThreadExecutor的使用
 * @author code-tulip
 * @Date 2019/5/27 2:55 PM
 * @Version 1.0
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {
        // SingleThreadExecutor可以看做是线程数量为1的FixedThreadPool
        // 提交了多个任务的话，这些任务将排队，所有的任务将使用相同的线程
        // 确保任意时刻在任何线程中都只有唯一的任务在运行
        // SingleThreadExecutor会序列化所有提交给它的任务，并会维护它自己隐藏的悬挂任务队列
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
