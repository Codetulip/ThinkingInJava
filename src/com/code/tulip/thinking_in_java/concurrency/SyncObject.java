package com.code.tulip.thinking_in_java.concurrency;

/**
 * @Classname SyncObject
 * @Description 在其他对象上完成同步
 * @author code-tulip
 * @Date 2019/5/28 11:31 PM
 * @Version 1.0
 */

class DualSynch {
    private Object syncObject = new Object();

    public synchronized void f() { // 相当于在this上同步
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}


public class SyncObject {

    public static void main(String[] args) {
        // 演示了两个任务同时进入同一个对象
        final DualSynch ds = new DualSynch();
        new Thread(){
            @Override
            public void run() {
                ds.f(); // f()方法占用的是DualSynch对象的锁
            }
        }.start();
        ds.g(); // g()方法占用的是其他对象的锁
    }
}
