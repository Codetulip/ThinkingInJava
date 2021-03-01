package com.code.tulip.thinking_in_java.holding;

import java.util.*;

/**
 * FileName: AddingGroups
 *
 * @author code-tulip
 * Date:     2019/4/27 20:16
 * Description: 接受一组元素组成集
 */
public class AddingGroups {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        collection.add(2); // 此处不会异常
        Integer[] moreInts = new Integer[]{6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        // 以下是常用方式，且运行速度较快
        Collections.addAll(collection, 11, 12, 13, 14, 15);// 可变参数列表
        Collections.addAll(collection, moreInts); // 这种方法运行速度较快
        //使用以下方法生成的List，其底层表示的是数组，因此不可以改变数组尺寸
        List<Integer> li = Arrays.asList(16, 17, 18, 19, 20); // 可变参数列表
        li.set(1, 99);
        // li.add(21); // 会出现UnsupportedOperationException异常
    }

}