package com.code.tulip.thinking_in_java.concurrency;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Classname NIOInterruption
 * @Description NIO的使用(interrupt()可被nio类接受从而中断)
 * @author code-tulip
 * @Date 2019/5/29 12:20 PM
 * @Version 1.0
 */

class NIOBlocked implements Runnable {

    private final SocketChannel sc;

    public NIOBlocked(SocketChannel sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read() in " + this);
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            System.out.println("ClosedByInterruptException");
        } catch (AsynchronousCloseException e) {
            System.out.println("AsynchronousCloseException");
        } catch (IOException e) {
            throw new RuntimeException();
        }
        System.out.println("exiting NIOBlocked.run() " + this);
    }
}

public class NIOInterruption {

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);

        Future<?> f = executorService.submit(new NIOBlocked(sc1));
        executorService.execute(new NIOBlocked(sc2));
        executorService.shutdown();

        TimeUnit.SECONDS.sleep(1);
        // 使用FUTURE发送cancel()的中断信号
        f.cancel(true); // 对于nio来说生效了
        TimeUnit.SECONDS.sleep(1);
        // 通过关闭底层资源关闭channel
        sc2.close();
    }
}
