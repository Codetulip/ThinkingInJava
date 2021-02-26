package com.code.tulip.thinking_in_java.designPatterns.iterator.withIterator;

import java.util.ArrayList;

/**
 * @Classname ProjectIterator
 * @Description
 * @author code-tulip
 * @Date 2019/6/16 2:43 PM
 * @Version 1.0
 */
public class ProjectIterator<T> implements IProjectIterator<T> {

    // 存放所有项目的ArrayList
    private ArrayList<T> list = new ArrayList<>();
    private int currentItem = 0;


    public ProjectIterator(ArrayList<T> list) {
        this.list = list;
    }

    // 判断是否还有项目
    @Override
    public boolean hasNext() {
        // 定义一个返回值
        boolean flag = true;
        if (currentItem >= list.size() || this.list.get(this.currentItem) == null) {
            flag = false;
        }
        return flag;
    }

    // 返回当前项目并向下一个项目移动
    @Override
    public T next() {
        return (T) this.list.get(this.currentItem++);
    }

    // 删除当前项目
    @Override
    public void remove() {
        throw new UnsupportedOperationException("该操作不受支持");
    }
}
