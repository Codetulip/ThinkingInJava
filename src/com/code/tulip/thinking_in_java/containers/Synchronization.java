/**
 * FileName: Synchronization
 * @author:   Code
 * Date:     2019/5/14 13:22
 * Description: Colletion或Map的同步控制
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.containers;

import java.util.*;

public class Synchronization {

    public static void main(String[] args) {
        Collection<String> c = Collections.synchronizedCollection(Utilities.list);
        Collection<String> cc = Collections.synchronizedCollection(new ArrayList<String>());
        List<String> list = Collections.synchronizedList(new ArrayList<String>());

        Set<String> s = Collections.synchronizedSet(new HashSet<String>());
        Set<String> ss = Collections.synchronizedSortedSet(new TreeSet<String>());

        Map<String, String> m = Collections.synchronizedMap(new HashMap<String, String>());
        Map<String, String> mm = Collections.synchronizedSortedMap(new TreeMap<String, String>());
    }
}
