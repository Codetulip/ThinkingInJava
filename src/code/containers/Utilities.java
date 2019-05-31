/**
 * FileName: utilities
 * Author:   Code
 * Date:     2019/5/13 13:08
 * Description: Collections的实用方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.containers;

import java.util.*;

public class Utilities {

    static List<String> list = Arrays.asList("one Two three Four five six one".split(" "));

    public static void main(String[] args) {
        System.out.println(list);
        // Collection.singletonList(T x)返回只包含指定参数的不可变List
        // disjoint互斥
        System.out.println("'list' disjoint (Four)?:" +
                Collections.disjoint(list, Collections.singletonList("Four")));
        System.out.println("max: " + Collections.max(list));
        System.out.println("min: " + Collections.min(list));
        System.out.println("max with comparator:" + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
        List<String> sublist = Arrays.asList("Four five six".split(" "));
        System.out.println("index of sublist: " + Collections.indexOfSubList(list, sublist));
        System.out.println("last index of sublist: " + Collections.lastIndexOfSubList(list, sublist));
        Collections.replaceAll(list, "one", "Yo");
        System.out.println("replaceAll: " + list);
        Collections.reverse(list);
        System.out.println("reverse list: " + list);
        // 旋转List，元素整体后移3个位置
        Collections.rotate(list, 3);
        System.out.println("rotate list, distance 3: " + list);
        List<String> source = Arrays.asList("in the matrix a a a a".split(" "));
        // 将元素全部复制到list中，参数均为List,直接覆盖式的复制，source为多少个就复制前多少个
        // 而且替换的List大小不能超过源List,source.size()<=list.size()
        // 否则会异常java.lang.IndexOutOfBoundsException: Source does not fit in dest
        // 前[three, Two, Yo, Yo, six, five, Four]
        // 后[in, the, matrix, a, a, a, a]
        Collections.copy(list, source);
        System.out.println("copy: " + list);
        // 交换指定位置的元素，通常比自己写的代码速度快
        Collections.swap(list, 0, list.size()-1);
        System.out.println("swap: " + list);
        // 随机打乱List
        Collections.shuffle(list, new Random(47));
        System.out.println("shuffle: " + list);
        // 直接全部替换成'pop'
        Collections.fill(list, "pop");
        System.out.println("fill: " + list);
        System.out.println("frequency of 'pop': " + Collections.frequency(list, "pop"));
        // 生成包含指定数目字符串（全部相同）的list
        List<String> dups = Collections.nCopies(4, "snap");
        System.out.println("dups: " + dups);
        System.out.println("'list' disjoint 'dups'?:" + Collections.disjoint(list, dups));
        // 生成一个旧式的Enumeration
        Enumeration<String> e = Collections.enumeration(dups);
        Vector<String> v = new Vector<String>();
        while (e.hasMoreElements()) {
            v.addElement(e.nextElement());
        }
        // 返回一个数组列表Collections.list(Enumeration<T> e)
        ArrayList<String> arrayList = Collections.list(v.elements());
        System.out.println("arraylist: " + arrayList);
    }
}
