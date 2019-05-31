/**
 * FileName: AssociativeArray
 * Author:   Code
 * Date:     2019/5/10 15:24
 * Description: 关联数组，map的简单实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.containers;

import java.util.HashMap;

// 只是了解map的结构，此实现简单，缺乏效率，尺寸也固定
public class AssociativeArray<K, V> {

    private Object[][] pairs;

    private int index;
    // 记录数组存放数据组的数量，因为创建数组的时候会指定数组实际大小，
    // 但是里面如果没有数据会指定为null，0，（char）O等

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index > pairs.length) {
            //可以采用某个方法grow数组，像ArrayList那样
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[]{key, value};
    }

    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++){
            sb.append(pairs[i][0].toString());
            sb.append(" : ");
            sb.append(pairs[i][1].toString());
            if (i < index - 1)
                sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<String, String>(6);
        map.put("xixi", "haha");
        map.put("xixi", "haha");
        map.put("xixi", "haha");
        map.put("xixi", "haha");
        map.put("xixi", "haha");
        map.put("xixi", "haha");
        try {
            map.put("xixi", "haha");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组太多了");
        }
        String value = map.get("xixi");
        System.out.println(map + value);

        // HashMap的小测试
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String s = new String("xixi");
        hashMap.put(s, "haha");
        hashMap.put(s, "heeh"); // 覆盖了“haha”，键必须唯一，如果不唯一，put同一个键会覆盖
        System.out.println(hashMap);
    }
}
