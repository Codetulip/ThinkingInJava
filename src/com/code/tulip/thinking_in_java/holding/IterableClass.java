package com.code.tulip.thinking_in_java.holding;

import java.util.Iterator;

/**
 * FileName: IterableClass
 *
 * @author codetulip
 * Date:     2019/4/28 15:58
 * Description: 迭代器实现接口
 */
public class IterableClass implements Iterable {

    private String[] words = ("And that is how" +
            " we know the Earth to be banana-shaped").split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }

    public static void main(String[] args) {
        // for (String s : new IterableClass()) { // 会报错需求类型不兼容
        // 所有Collection类都是Iterable类型，但是不包括各种Map
        for (Object s : new IterableClass()) {
            System.out.print(s + " ");
        }
    }
}
