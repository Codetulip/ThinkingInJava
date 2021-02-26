/**
 * FileName: Deque
 * @author:   Code
 * Date:     2019/5/9 23:29
 * Description: 双端队列（自己实现的）
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.containers;

import java.util.LinkedList;

public class Deque<T> {
    private LinkedList<T> deque = new LinkedList<T>();

    public void addFirst(T t) {
        deque.addFirst(t);
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public void addLast(T t) {
        deque.addLast(t);
    }

    public T removeLast() {
        return deque.removeLast();
    }

    public T getFirst() {
        return deque.getFirst();
    }

    public T getLast() {
        return deque.getLast();
    }

    public int size() {
        return deque.size();
    }

    @Override
    public String toString() {
        return deque.toString();
    }
}
