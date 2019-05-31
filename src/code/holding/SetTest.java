/**
 * FileName: SetTest
 * Author:   Code
 * Date:     2019/4/28 13:34
 * Description: HashSet，TreeSet试用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.holding;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new TreeSet<>();
        Collections.addAll(set1, "A H B J O H L L".split(" "));
        Collections.addAll(set2, "A H B a O b L h".split(" "));
        System.out.println(set1);
        System.out.println(set2);
        // 不考虑大小写,此时大写字母和对应小写字母相等，因此只添加一个（先出现的）
        // 此时是传入一种比较器，comparator接口
        Set<String> set3 = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Collections.addAll(set3, "A H B c O d L i a".split(" "));
        System.out.println(set3);
        for (String s : set1) {
            System.out.print(s + " ");
        }
    }
}
