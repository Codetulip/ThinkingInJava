package com.code.tulip.thinking_in_java.designPatterns.iterator.universalCode;

import java.util.Vector;

/**
 * @Classname ConcreteIterator
 * @Description 具体迭代器
 * @author code-tulip
 * @Date 2019/6/16 3:14 PM
 * @Version 1.0
 */
public class ConcreteIterator implements Iterator {

    private Vector vector = new Vector();

    // 定义游标
    public int cursor = 0;

    @SuppressWarnings("unchecked")
    public ConcreteIterator(Vector vector) {
        this.vector = vector;
    }

    @Override
    public Object next() {
        Object o = null;
        if (this.hasNext()) {
            o = this.vector.get(this.cursor++);
        } else {
            o = null;
        }
        return o;
    }

    @Override
    public boolean hasNext() {
        if (this.cursor == this.vector.size()) {
            return false;
        } else {
            return true;
        }
    }

}
