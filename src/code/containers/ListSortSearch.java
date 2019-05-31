/**
 * FileName: ListSortSearch
 * Author:   Code
 * Date:     2019/5/13 14:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.containers;

import java.util.*;

public class ListSortSearch {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Utilities.list);
        list.addAll(Utilities.list);
        System.out.println(list);
        Collections.shuffle(list, new Random(47));
        System.out.println("shuffled: " + list);
        // 映射关系
        // 从指定位置开始到末尾，而不是一个循环链表样式
        ListIterator<String> it = list.listIterator(10);
        while (it.hasNext()) {
            it.next();
            // 删除
            it.remove();
        }
        System.out.println("trimmed: " + list);
        Collections.sort(list);
        System.out.println("Sorted: " + list);
        // 观察以下两种sort和binarySearch方法的区别
        // 如果sort方法使用比较器排序，对应binarySearch方法的也要放入相同的比较器
        String key = list.get(7);
        int index = Collections.binarySearch(list, key);
        System.out.println("location of " + key + " is " + index +
                ", list.get(" + index + ") = " + list.get(index));
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-insensitive sorted: " + list);
        key = list.get(7);
        index = Collections.binarySearch(list, key, String.CASE_INSENSITIVE_ORDER); //最后比较器要不要无所谓的
        System.out.println("location of " + key + " is " + index +
                ", list.get(" + index + ") = " + list.get(index));
    }
}
