package com.code.tulip.thinking_in_java.holding;

import java.util.LinkedList;
/**
 * FileName: Stack
 * @author   code-tulip
 * Date:     2019/4/27 21:52
 * Description: 利用LinkedList实现栈
 */
public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<>();
    public void push(T t) {storage.addFirst(t);}
    public T peek() {return storage.getFirst();}
    public T pop() {return storage.removeFirst();}
    public boolean empty() {return storage.isEmpty();}
    @Override
    public String toString() {return storage.toString();}
}
