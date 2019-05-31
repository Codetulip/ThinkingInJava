/**
 * FileName: ReadOnly
 * Author:   Code
 * Date:     2019/5/13 15:13
 * Description: 只读容器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.containers;

import java.util.*;

public class ReadOnly {

    static Collection<String> data = new ArrayList<String>(Utilities.list);

    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<String>(data));
        System.out.println(c);
        // c.add("xixi"); // java.lang.UnsupportedOperationException

        List<String> a = Collections.unmodifiableList(new ArrayList<String>(data));
        ListIterator<String> lit = a.listIterator();
        System.out.println(lit.next());
        // lit.add()

        Set<String> s = Collections.unmodifiableSet(new HashSet<String>(data));
        System.out.println(s);
        // s.add()

        Set<String> ss = Collections.unmodifiableSortedSet(new TreeSet<String>(data));
        System.out.println(ss);
        // ss.add()

        Map<String, String> m = Collections.unmodifiableMap(new HashMap<String, String>());
        System.out.println(m);
        // m.put()

        Map<String, String> mm = Collections.unmodifiableSortedMap(new TreeMap<String, String>());
        System.out.println(mm);
        // mm.put()
    }
}
