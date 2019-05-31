/**
 * FileName: MapTest
 * Author:   Code
 * Date:     2019/4/28 14:04
 * Description: HashMap,TreeMap,LinkedHashMap
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.holding;

import java.util.*;

public class MapTest {

    public static void main(String[] args) {
        String[] key = {"a", "d", "cc", "hu", "liu"};
        Random rand = new Random(47);
        Map<String, Integer> map1 = new HashMap<>(); // 散列码
        Map<String, Integer> map2 = new TreeMap<>(); // 升序(可传入排序的comparator)
        Map<String, Integer> map3 = new LinkedHashMap<>(); // 插入顺序
        for (String s : key) {
            map1.put(s, rand.nextInt(20));
            map2.put(s, rand.nextInt(20));
            map3.put(s, rand.nextInt(20));
        }
        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);

        for (Map.Entry entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            entry.setValue(1);  // Map.Entry为映射项，此处修改，原MAP中也会修改
        }
        for (String s : map1.keySet()) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (Integer i : map1.values()) {
            System.out.print(i + " ");
        }
    }

}
