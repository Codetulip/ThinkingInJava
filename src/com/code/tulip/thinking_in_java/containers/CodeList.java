/**
 * FileName: CodeList
 * @author:   Code
 * Date:     2019/5/9 15:21
 * Description: AbstractList的实现（只读），包含一些容器方法的使用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.containers;

import java.util.*;


public class CodeList extends AbstractList<Integer> {

    private int size;

    CodeList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public Integer get(int index) {
        return Integer.valueOf(index);
        // list底层是Object[]
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        List list = new CodeList(1);
        Object[] objects = list.toArray(); // 自己实现的list，未实现下面的方法
        // 容器变数组
        String[] strings = new ArrayList<>().toArray(new String[0]);
        Set<String> set = new HashSet<String>();
        set.add("s");
        Object[] a =  set.toArray();
        // 在toArray(指定返回类型)，仅仅指定返回类型，并不包含任何数据
        String[] b = set.toArray(new String[0]);
        System.out.println(Arrays.toString(a) + "\n" + Arrays.toString(b));
        // 返回比较器
        Comparator<Object> objectComparator = Collections.reverseOrder();
        Comparator<String> objectComparator1 = Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER);
    }
}
