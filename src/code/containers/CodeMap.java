/**
 * FileName: CodeMap
 * Author:   Code
 * Date:     2019/5/9 14:41
 * Description: AbstractMap的实现（只读）
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.containers;

import java.util.*;

class Xixi extends AbstractMap {

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}

public class CodeMap extends AbstractMap<String, String> {

    public static String[][] DATA = {};

    // 需要实现自己的entrySet()方法，就先得实现自己的Map.Entry类型（定制的Map.Entry类型）
    private static class Entry implements Map.Entry<String, String> {

        int index;

        Entry(int index) {
            this.index = index;
        }

        @Override
        public String getKey() {
            return DATA[index][0];
        }

        @Override
        public String getValue() {
            return DATA[index][1];
        }

        @Override
        public String setValue(String value) {
            throw new RuntimeException();
        }

    }

    // 实现自己的entrySet()方法返回的Set类型(定制的Set类型)
    static class EntrySet extends AbstractSet<Map.Entry<String, String>> {

        private int size;

        EntrySet(int size) {
            if (size < 0)
                this.size = 0;
            else if (size > DATA.length)
                this.size = DATA.length;
            else
                this.size = size;
        }

        @Override
        public Iterator<Map.Entry<String, String>> iterator() {
            return new Iterator<Map.Entry<String, String>>() {

                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size - 1;
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }
            };
        }

        @Override
        public int size() {
            return size;
        }
    }

    private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

    //返回entrySet
    @Override
    public Set<Map.Entry<String, String>> entrySet() {
        return entries;
    }
}
