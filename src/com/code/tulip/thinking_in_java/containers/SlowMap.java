/**
 * FileName: SlowMap
 * @author:   Code
 * Date:     2019/5/12 15:09
 * Description: 自己实现的Map(使用ArrayList)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.containers;

import java.util.*;

public class SlowMap<K, V> extends AbstractMap<K, V> {

    // K-V值对应放入ArrayList中
    private List<K> kList = new ArrayList<K>();

    private List<V> vList = new ArrayList<V>();

    // put方法要返回旧值
    @Override
    public V put(K key, V value){
        V oldValue = get(key);
        if (!kList.contains(key)) {
            kList.add(key);
            vList.add(value);
        } else {
            vList.set(kList.indexOf(key), value);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        if (!kList.contains(key)) {
            return null;
        }
        return vList.get(kList.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<Entry<K, V>>();
        Iterator<K> kIterator = kList.iterator();
        Iterator<V> vIterator = vList.iterator();
        while (kIterator.hasNext()) {
            entries.add(new MapEntry<K, V>(kIterator.next(), vIterator.next()));
        }
        return entries;
    }

    public static void main(String[] args) {
        SlowMap<Integer, String> slowMap = new SlowMap<Integer, String>();
        LinkedHashMapDemo.test(slowMap);
        System.out.println(slowMap);
    }
}
