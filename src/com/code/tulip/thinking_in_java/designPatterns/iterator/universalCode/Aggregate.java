package com.code.tulip.thinking_in_java.designPatterns.iterator.universalCode;

/**
 * @Interfacename Aggreate
 * @Description 抽象容器
 * @author code-tulip
 * @Date 2019/6/16 3:18 PM
 * @Version 1.0
 */
public interface Aggregate {

    // 容器中元素的添加
    public void add(Object o);

    // 删除元素
    public void remove(Object o);

    // 返回迭代器遍历所有元素
    public Iterator iterator();
}
