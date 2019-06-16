package code.designPatterns.iterator.universalCode;

/**
 * @Classname Interator
 * @Description 抽象迭代器
 * @Author tujing
 * @Date 2019/6/16 3:12 PM
 * @Version 1.0
 */
public interface Iterator {

    // 遍历到下一个元素
    public Object next();

    // 判断是否到了末尾
    public boolean hasNext();

    // 删除当前指向的元素
    default void remove() {
        throw new UnsupportedOperationException();
    }
}
