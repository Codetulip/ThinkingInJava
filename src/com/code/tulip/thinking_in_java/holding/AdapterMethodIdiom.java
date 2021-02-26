package com.code.tulip.thinking_in_java.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * FileName: ReversibleArrayList
 *
 * @author code-tulip
 * Date:     2019/4/28 23:04
 * Description: 适配器方法实现方向迭代器
 */
public class AdapterMethodIdiom {

    public static void main(String[] args) {
        ReversibleArrayList<String> reversibleArrayList =
                new ReversibleArrayList<>(Arrays.asList("To be or not to be".split(" ")));
        for (String s : reversibleArrayList) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : reversibleArrayList.reversed()) {
            System.out.print(s + " ");
        }
        // foreach的底层实现
        /*Iterator it = reversibleArrayList.reversed2();
        while (it.hasNext()) {
            System.out.println(it.next());
        }*/
    }
}

class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    /**
     * 方法内利用匿名内部类实现Iterable接口
     */
    public Iterable<T> reversed() {
        return () -> new Iterator<T>() {
            int current = size() - 1;

            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public T next() {
                return get(current--);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /*public Iterator<T> reversed2() {
        return new Iterator<T>() {
            int current = size() - 1;

            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public T next() {
                return get(current--);
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }*/
}
