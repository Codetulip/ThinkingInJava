/**
 * FileName: SortedMapDemo
 * @author:   Code
 * Date:     2019/5/12 13:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.containers;

import java.util.Iterator;
import java.util.TreeMap;

public class SortedMapDemo {

    public static void main(String[] args) {
        TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>();
        LinkedHashMapDemo.test(sortedMap);
        System.out.println(sortedMap);
        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        System.out.println("low : " + low + "   high : " + high);
        Iterator<Integer> it = sortedMap.keySet().iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) {
                low = it.next();
            }
            if (i == 6) {
                high = it.next();
            } else {
                it.next();
            }
        }
        sortedMap.headMap(high);
        sortedMap.tailMap(low);
        sortedMap.subMap(low, high);
    }
}
