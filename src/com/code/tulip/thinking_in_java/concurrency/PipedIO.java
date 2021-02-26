package com.code.tulip.thinking_in_java.concurrency;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Classname PipedIO
 * @Description 任务间使用管道进行输入\输出
 * @author code-tulip
 * @Date 2019/5/29 11:35 PM
 * @Version 1.0
 */

class Sender implements Runnable {

    private Random random = new Random(47);

    private PipedWriter out = new PipedWriter();

    public PipedWriter getPipedWriter() {
        return out;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'Z'; c++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e + " Sender write exception");
        } catch (IOException e) {
            System.out.println(e + "Sender sleep interrupted");
        }
    }
}

class Receiver implements Runnable {

    private PipedReader in;

    public PipedReader getPipedReader() {
        return in;
    }

    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter()); // 将管道连接起来(PipedWriter也可以这样连接)
//        in.connect(sender.getPipedWriter()); // 或者这样连接
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.print("Read: " + (char) in.read() + ", "); // 没有更多数据的时候，管道将自动阻塞
            }
        } catch (IOException e) {
            System.out.println(e + " Receiver read exception");
        }
    }
}

public class PipedIO {

    public static void main(String[] args) throws Exception{
        // 两个互相通信的任务
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(sender);
        executorService.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        executorService.shutdownNow(); //PipedReader是可中断的
    }
}
