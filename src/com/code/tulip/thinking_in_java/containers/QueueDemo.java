/**
 * FileName: QueueDemoo
 * @author:   Code
 * Date:     2019/5/9 21:05
 * Description: LinkedList和PriorityQueue的比较
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.containers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;


class StringComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        // 字符串比较大小用compareTo()函数，相等返回0，不等返回差值
        return (-o1.compareTo(o2));
    }
}

public class QueueDemo {

    static void generator(Queue queue) {
        queue.add("xixi");
        queue.add("haha");
        queue.add("hehe");
    }

    static void test(Queue queue) {
        generator(queue);
        System.out.println(queue.getClass().getName() + " : " + queue);
    }

    public static void main(String[] args) {
        // 保持插入顺序
        LinkedList<String> linkedList = new LinkedList<String>();
        test(linkedList);
        // 某种顺序存放，根据某种优先级顺序取出
//        PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
        //注意观察两种优先级队列，下面放入了比较器，但是存储顺序依然没有变化，说明比较器决定的是优先级（也就是取出顺序）
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>(new StringComp());
        test(priorityQueue);
        // 以下两种方法输出PriorityQueue元素结果不一样
        //PriorityQueue :[haha, xixi, hehe]
        System.out.println("PriorityQueue :" + priorityQueue);
        //haha hehe xixi，通过添加比较器可以改变其取出顺序
        while (priorityQueue.peek() != null) {
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.println();
        // 以下是各种Queue的测试
        test(new LinkedList<String>());
        test(new PriorityQueue<String>());
        test(new ArrayBlockingQueue<String>(10)); // 固定尺寸的阻塞队列
        test(new ConcurrentLinkedQueue<String>());
        test(new LinkedBlockingQueue<String>()); // 无界阻塞队列
        test(new PriorityBlockingQueue<String>()); // 优先无界阻塞队列

    }
}
