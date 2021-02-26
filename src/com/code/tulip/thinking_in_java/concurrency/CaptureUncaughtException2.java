package com.code.tulip.thinking_in_java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname CaptureUncaughtException2
 * @Description 捕获线程产生的异常（所有地方都使用相同的异常处理器）
 * @author code-tulip
 * @Date 2019/5/28 12:00 PM
 * @Version 1.0
 */
public class CaptureUncaughtException2 {

    public static void main(String[] args) {
        // 所有地方都使用相同的异常处理器
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());
    }
}
