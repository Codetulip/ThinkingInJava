/**
 * FileName: FillingLists
 * Author:   Code
 * Date:     2019/5/9 13:53
 * Description: List的填充
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.containers;

import java.util.*;

class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    public String toString() {
        return super.toString() + " " + s;
    }
}

public class FillingLists {

    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<StringAddress>(
                Collections.nCopies(4, new StringAddress("Hello")) // 此方法返回值为List
        );
        // 相同的引用，复制
        StringAddress[] a = {new StringAddress("Hello"), new StringAddress("Hello")};
        System.out.println(list);
        Collections.addAll(list, new StringAddress("Hello"), new StringAddress("Hello"));
        Collections.addAll(list, a);
        System.out.println(list);
        // 相同的引用，将List中所有对象全部换掉,fill(List, 参数)只能用于list
        // 只能替换，不能添加
        Collections.fill(list, new StringAddress("world!"));
        list.addAll(list);
        System.out.println(list);

        // 简单的ArrayList和LinkedList的测试
        // ArrayList和LinkedList都保持了元素的插入顺序
        // 区别在于AyyayList善于随机访问，LinkedList中间插入和删除速度更快
        List<StringAddress> list1 = new ArrayList<StringAddress>();
        list1.addAll(Arrays.asList(a));
        List<StringAddress> list2 = new LinkedList<StringAddress>();
        list2.addAll(Arrays.asList(a));
        System.out.println(list1 + "\n" + list2);
    }

}
