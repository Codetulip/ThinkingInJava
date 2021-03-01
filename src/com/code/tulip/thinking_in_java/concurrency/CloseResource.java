package com.code.tulip.thinking_in_java.concurrency;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Classname CloseResource
 * @Description 无法中断io输入\输出的解决方案
 * @author code-tulip
 * @Date 2019/5/29 1:06 AM
 * @Version 1.0
 */

// 通过关闭任务在其上发生阻塞的底层资源，从而解决无法中断的问题
public class CloseResource {

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost", 8080).getInputStream();
        executorService.execute(new IOBlocked(socketInput));
        executorService.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("shutting down all threads");
        // 虽然发送了interrupt()信号，但是无法中断io和synchronized的尝试，因此任务实际并有结束
        executorService.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("closing " + socketInput.getClass().getName());
        socketInput.close(); // 关闭底层资源，底层资源关闭后，等待输入的read()自行结束了(解除阻塞)
        TimeUnit.SECONDS.sleep(1);
        System.out.println("closing " + System.in.getClass().getName());
        System.in.close(); // 关闭底层资源
    }
}
