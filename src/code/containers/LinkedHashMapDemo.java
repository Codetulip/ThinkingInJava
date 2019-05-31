/**
 * FileName: LinkedHashMapDemo
 * Author:   Code
 * Date:     2019/5/12 13:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.containers;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void test(Map map) {
        map.put(1, "xixi");
        map.put(3, "haha");
        map.put(2, "hehe");
        map.put(5, "hehe");
        map.put(4, "hehe");
        map.put(6, "hehe");
        map.put(8, "hehe");
        map.put(10, "hehe");
        map.put(7, "hehe");
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap =
                new LinkedHashMap<Integer, String>();
        test(linkedHashMap);
        System.out.println(linkedHashMap);
        // 设置最近最少使用算法(LRU)
        linkedHashMap = new LinkedHashMap<Integer, String>(16, 0.75f, true);
        test(linkedHashMap);
        for (int i = 0; i < 6; i++) {
            linkedHashMap.get(i);
        }
        System.out.println(linkedHashMap);
        linkedHashMap.get(1);
        System.out.println(linkedHashMap);
        // 最近使用的过的放到map的最后位置，最近最少使用的放在map最前面
    }
}
