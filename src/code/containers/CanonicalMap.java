/**
 * FileName: CanonicalMap
 * Author:   Code
 * Date:     2019/5/15 14:22
 * Description: 规范映射
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.containers;


import java.util.WeakHashMap;

class Element {
    private String ident;

    public Element(String id) {
        ident = id;
    }

    public String toString() {
        return ident;
    }

    public int hashCode() {
        return ident.hashCode();
    }

    public boolean euquals(Object r) {
        return r instanceof Element && ident.equals(((Element) r).ident);
    }

    public void finalize() {
        System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
    }
}

class Key extends Element {
    public Key(String id) {
        super(id);
    }
}

class Value extends Element {

    public Value(String id) {
        super(id);
    }
}
<<<<<<< HEAD
=======

>>>>>>> initial commit
// 利用WeakHashMap保存WeakReference
public class CanonicalMap {

    public static void main(String[] args) {
        int size = 1000;
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<Key, Value>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0) {
                keys[i] = k; // 保存为真正的对象
            }
            map.put(k, v);
        }
        System.gc(); // map中数据被清理了一部分
    }
}
