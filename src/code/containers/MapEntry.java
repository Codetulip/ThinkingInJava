/**
 * FileName: MapEntry
 * Author:   Code
 * Date:     2019/5/12 15:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.containers;

import java.util.Map;


public class MapEntry<K, V> implements Map.Entry<K, V> {

    private K key;

    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    // setValue方法返回修改前的原值
    @Override
    public V setValue(V value) {
        V result = this.value;
        this.value = value;
        return result;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    public boolean equals(Object o) {
        if (o instanceof MapEntry) return false;
        MapEntry me = (MapEntry) o;
        return (key == null ? me.getKey() == null : key.equals(me.getKey())) &&
                        (value == null ? me.getValue() == null : value.equals(me.getValue()));
    }

    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^
                (value == null ? 0 : value.hashCode());
    }
}
