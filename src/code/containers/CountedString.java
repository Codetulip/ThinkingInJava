/**
 * FileName: CountedString
 * Author:   Code
 * Date:     2019/5/12 20:14
 * Description: 如何写出hashCode()指导
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountedString {

    //1.给int变量result赋予某个非零值常量
    //2.为对象内每个有意义的域f（即每个可以做equals（）操作的域）计算出一个int散列码c
    //3.合并计算散列码 result = result * 37 + c
    //4.返回result
    //5.检查hashCode()最后生成的结果，确保相同的对象有相同的散列码

    private static List<String> created = new ArrayList<String>();

    //两个有意义的域
    private String s;

    private int id = 0;

    public CountedString(String str) {
        this.s = str;
        created.add(s);
        // id用来记录同一个字符串使用的次数
        for (String s1 : created) {
            if (s1.equals(s))
                id++;
        }
    }

    public String toString() {
        return "String: " + s + " id:" + id + " hashCode():" + hashCode();
    }

    public int hashCode() {
        int result = 17;
        result = result * 37 + s.hashCode();
        // 移除ID的引用后，main中产生的所有String内容相同，所以s.hashCode()值也相同
        // 导致所有CountedString的hashCode()也相同，当时依然可以使用
        // 与SimpleHashMap原理一样高
        result = result * 37 + id;
        return result;
    }

    // equals（）方法很重要
    public boolean equals(Object o) {
        return o instanceof CountedString && s.equals(((CountedString) o).s)
                && id == ((CountedString) o).id;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<CountedString, Integer>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < 5; i++ ) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString c : cs) {
            System.out.println("Looking up " + c);
            System.out.println(map.get(c));
        }
    }
}
