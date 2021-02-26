package com.code.tulip.thinking_in_java.concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Classname CallableDemo
 * @Description 从线程任务中返回值
 * @author code-tulip
 * @Date 2019/5/27 3:05 PM
 * @Version 1.0
 */

//  Callable泛型指定返回值类型
class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 5; i++) {
            // submit方法提交一个任务用于执行，并返回一个表示该任务未来结果的Future
            // Future表示异步计算的结果。
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> future : results) {
            try {
                System.out.println(future.get()); // 如果future未完成，get()方法将会阻塞直到结果准备就绪
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                executorService.shutdown();
            }
        }
    }
}
