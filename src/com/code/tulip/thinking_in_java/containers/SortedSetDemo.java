/**
 * FileName: SortedSetDemo
 * @author:   Code
 * Date:     2019/5/9 20:53
 * Description: SortedSet
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.containers;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<String>();
        Collections.addAll(sortedSet, "one two three four five" +
                " six seven eight".split(" "));
        System.out.println(sortedSet.comparator()); // 如果使用的元素的自然排序则返回null
        ((TreeSet<String>) sortedSet).subSet("one", "two");
        ((TreeSet<String>) sortedSet).headSet("two");
        ((TreeSet<String>) sortedSet).tailSet("one");

        TreeSet<SList> objects = new TreeSet<SList>();
        objects.add(new SList());
        objects.add(new SList());
        System.out.println(objects);
    }

}
