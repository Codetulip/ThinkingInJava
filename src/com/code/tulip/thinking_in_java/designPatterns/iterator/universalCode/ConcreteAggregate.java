package com.code.tulip.thinking_in_java.designPatterns.iterator.universalCode;

import java.util.Vector;

/**
 * @Classname ConcreteAggregate
 * @Description 具体容器
 * @author code-tulip
 * @Date 2019/6/16 3:20 PM
 * @Version 1.0
 */
public class ConcreteAggregate implements Aggregate {

    // 容纳对象的容器
    private Vector vector = new Vector();

    @Override
    public void add(Object o) {
        this.vector.add(o);
    }

    @Override
    public void remove(Object o) {
        this.vector.remove(o);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this.vector);
    }
}
