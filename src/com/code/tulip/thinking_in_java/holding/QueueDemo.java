package com.code.tulip.thinking_in_java.holding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Simple {}

/**
 * FileName: QueueDemo
 * @author   code-tulip
 * Date:     2019/4/28 14:17
 * Description: 队列的案例
 */
public class QueueDemo {

    /**
     * 打印队列
     */
    public static void printQ(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue1.offer(rand.nextInt(i + 10));
        }
        printQ(queue1);
        Queue<Character> queue2 = new LinkedList<>();
        for (char c : "brontosaurus".toCharArray()) {
            queue2.offer(c);
        }
        printQ(queue2);
    }
}
