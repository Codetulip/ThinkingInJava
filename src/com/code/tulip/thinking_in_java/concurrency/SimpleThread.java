package com.code.tulip.thinking_in_java.concurrency;

/**
 * @Classname SimpleThread
 * @Description 另一种创建线程任务的方式,继承Thread
 * @author code-tulip
 * @Date 2019/5/27 3:54 PM
 * @Version 1.0
 */
public class SimpleThread extends Thread {

    private int countDown = 5;

    private static int threadCount = 0;

    public SimpleThread() {
        // 指定线程的名字
        super(Integer.toString(++threadCount));
        start(); // 在构造器中启动线程可能会有很多问题
    }

    @Override
    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
