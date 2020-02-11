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

import java.util.Collections;
import java.util.HashMap;
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
        // 设置最近最少使用算法(LRU, 不完全实现，没有实现剔除元素removeEldestEntry)
        linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
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

class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int cacheSize;

    public LRUCache(int cacheSize) {
        // accessOrder要为true，表示保持获得顺序
        // false表示插入顺序
        super(16, (float) 0.75, true);
        this.cacheSize = cacheSize;
    }

    /**
     * 重写removeEldestEntry的方法即可实现LRU，目的是判定什么时候剔除旧的函数
     * 该方法只是判定条件，具体操作在afterNodeInsertion有由removeNode实现
     *
     * @param eldest 旧的Map.Entry
     * @return LRU判定规则
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }


    /**
     * 测试使用的成员变量
     */
    private static LRUCache<String, Integer> cache = new LRUCache<>(10);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            cache.put("k" + i, i);
        }
        System.out.println("all cache :'{}'" + cache);
        cache.get("k3");
        System.out.println("get k3 :'{}'" + cache);
        cache.get("k4");
        System.out.println("get k4 :'{}'" + cache);
        cache.get("k4");
        System.out.println("get k4 :'{}'" + cache);
        cache.put("k" + 10, 10);
        System.out.println("After running the LRU algorithm cache :'{}'" + cache);
        System.out.println(cache.keySet());
        System.out.println(cache.values());
    }

}

class LFU<k, v> {
    private final int capcity;

    // 记录元素值
    private Map<k, v> cache = new HashMap<>();

    // 记录元素的次数和最新访问时间
    private Map<k, HitRate> count = new HashMap<>();

    public LFU(int capcity) {
        this.capcity = capcity;
    }

    public void put(k key, v value) {
        v v = cache.get(key);
        if (v == null) {
            if (cache.size() == capcity) {
                removeElement();
            }
            count.put(key, new HitRate(key, 1, System.nanoTime()));
        } else {
            addHitCount(key);
        }
        cache.put(key, value);
    }

    public v get(k key) {
        v value = cache.get(key);
        if (value != null) {
            addHitCount(key);
            return value;
        }
        return null;
    }

    // 移除元素
    private void removeElement() {
        HitRate hr = Collections.min(count.values());
        cache.remove(hr.key);
        count.remove(hr.key);
    }

    // 更新访问元素状态
    private void addHitCount(k key) {
        HitRate hitRate = count.get(key);
        hitRate.hitCount = hitRate.hitCount + 1;
        hitRate.lastTime = System.nanoTime();
    }

    // 内部类
    class HitRate implements Comparable<HitRate> {
        private k key;
        private int hitCount;
        private long lastTime;

        private HitRate(k key, int hitCount, long lastTime) {
            this.key = key;
            this.hitCount = hitCount;
            this.lastTime = lastTime;
        }

        @Override
        public int compareTo(HitRate o) {
            int compare = Integer.compare(this.hitCount, o.hitCount);
            return compare == 0 ? Long.compare(this.lastTime, o.lastTime) : compare;
        }
    }


    public static void main(String[] args) {
        LFU<Integer, Integer> cache = new LFU<>(3);
        cache.put(2, 2);
        cache.put(1, 1);

        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

        cache.put(3, 3);
        cache.put(4, 4);

        //1、2元素都有访问次数，放入3后缓存满，加入4时淘汰3
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        //System.out.println(cache.get(1));
        System.out.println(cache.get(4));

        cache.put(5, 5);
        //目前2访问2次，1访问一次，4访问一次，由于4的时间比较新，放入5的时候移除1元素。
        System.out.println("-=-=-=-");
        cache.cache.entrySet().forEach(entry -> {
            System.out.println(entry.getValue());
        });
    }
}