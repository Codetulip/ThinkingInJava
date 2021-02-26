/**
 * FileName: CopyingArrays
 * @author:   Code
 * Date:     2019/5/8 22:54
 * Description: 复制数组，数组的比较
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.arrays;

import java.util.Arrays;

public class CopyingArrays {

    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        System.out.println("i = " + Arrays.toString(i));
        System.out.println("j = " + Arrays.toString(j));
        // 源数组，源数组起始位置，目标数组，目标数组起始位置，复制数量（从源数组起始位置往后）
        // 任何越界操作都会导致异常，包括最后设置的复制数量
        // System.arraycopy()不会自动拆/装包
        // System.arraycopy()是原生方法，复制数组效率最高
        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("j = " + Arrays.toString(j));
        int[] k = new int[5];
        Arrays.fill(k, 103);
        System.arraycopy(i, 0, k, 0, k.length);
        System.out.println("k = " + Arrays.toString(k));
        Arrays.fill(k, 103);
        System.arraycopy(k, 0, i, 0, k.length);
        System.out.println("k = " + Arrays.toString(k));

        // 数组的比较
        System.out.println(Arrays.equals(i, j));
        String[] s1 = new String[5];
        Arrays.fill(s1, "hi");
        String[] s2 = {new String("hi"), new String("hi"),
                new String("hi"), new String("hi"),
                new String("hi")};
        // 数组的相等是基于内容的
        System.out.println(Arrays.equals(s1, s2));
        // 复制s1中所有元素到strings,并重新定义新数组的大小
        // ArrayList的底层实现
        // Arrays.copyOf()方法底层还是使用的System.arraycopy()因此效率没有System.arraycopy()高
        // clone()方法效率最低
        String[] strings = Arrays.copyOf(s1, 10);
        System.out.println(Arrays.toString(strings));
    }
}