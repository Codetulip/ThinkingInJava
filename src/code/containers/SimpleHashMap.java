/**
 * FileName: SimpleHashMap
 * Author:   Code
 * Date:     2019/5/12 16:48
 * Description: HashMap的简单实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.containers;

import java.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    static final int SIZE = 997;

    //Java不允许创建泛型数组new LinkedList<MapEntry<K, V>>[SIZE];
    // 但是可以像下面这样创建指向泛型数组的引用
    // 键的信息作为数组的下标，可能同一个键最后的下标相同，下标的相同的键放入一个LinkedList中
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];


    // 返回旧值
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE; // 键的信息
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }
        // 首先找到下标相同的key的linkedList
//        LinkedList<MapEntry<K, V>> bucket = buckets[index]; // 没必要
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        // 遍历这个List找到对应的key
        boolean found = false;
        // 使用迭代器进行遍历，迭代器与容器是对应的
        ListIterator<MapEntry<K, V>> it = buckets[index].listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> ipair = it.next();
            if (ipair.getKey().equals(key)) {
                oldValue = ipair.getValue();
                it.set(pair); // 迭代器与对应的容器是映射的
//                ipair.setValue(value); // 这种方式也可以
                found = true;
                break;
            }
        }
        if (found != true) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key) {
        // 获得键的信息
        int index = Math.abs(key.hashCode()) % SIZE;
        // 找到存储键信息的特定LinkedList,没找到返回null
        if (buckets[index] == null) return null;
        // 找到了遍历LinkedList，寻找对应的键，找不到返回null，找到了返回value
        for (MapEntry<K, V> mapEntry : buckets[index]) {
            if (mapEntry.getKey().equals(key))
                return mapEntry.getValue();
        }
        return null;
    }

    // 无法用于通用的Map
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<Entry<K, V>>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> mapEntry : bucket)
                entries.add(mapEntry);
        }
        return entries;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<String, String>();
        LinkedHashMapDemo.test(simpleHashMap);
        System.out.println(simpleHashMap);
        System.out.println(simpleHashMap.get(1));
        System.out.println(simpleHashMap.entrySet());
    }
}
