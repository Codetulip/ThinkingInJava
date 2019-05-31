package code.concurrency;

import code.util.Generator;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @Classname ExchangerDemo
 * @Description
 * @Author tujing
 * @Date 2019/5/30 12:54 PM
 * @Version 1.0
 */

// Exchanger是在两个任务间交换对象的栅栏
// 生产者负责生产对象，生产够数后利用Exchanger将所有生产品交给消费者
class ExchangerProducer<T> implements Runnable {

    private List<T> holder;

    private Exchanger<List<T>> exchanger;

    public ExchangerProducer(List<T> list, Exchanger<List<T>> exchanger) {
        this.holder = list;
        this.exchanger = exchanger;
    }

    private Generator<T> gen; // 负责产生对象的类

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++) {
                    holder.add(gen.next());
                }
                // 够数后进行交换，用满的List换回空的List
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

// 消费者线程
// 有了Exchanger，填充一个列表和消费另一个列表可以同时发生
class ExchangerConsumer<T> implements Runnable {

    private List<T> holder;

    private Exchanger<List<T>> exchanger;

    private volatile T value;

    public ExchangerConsumer(List<T> holder, Exchanger<List<T>> exchanger) {
        this.holder = holder;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder); // 利用此空的List换回满产品的List
                for (T x : holder) {
                    value = x;
                    holder.remove(x); // 一般容器不允许迭代的时候执行remove操作，但是CopyOnWriteArrayList可以
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final value " + value);
    }
}

public class ExchangerDemo {


    static int size = 10; // 规定产品数量

}
