package com.code.tulip.thinking_in_java.holding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/**
 * FileName: SimpleInteration
 * @author   code-tulip
 * Date:     2019/4/27 21:20
 * Description: 简单的迭代器
 */
public class SimpleIteration {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        ListIterator<Integer> li = list.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        for (Integer in : list) {
            System.out.print(in + " ");
        }
        System.out.println();
        it = list.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        System.out.println(list);

    }
}
