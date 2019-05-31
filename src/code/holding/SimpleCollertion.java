/**
 * FileName: SimpleCollertion
 * Author:   Code
 * Date:     2019/4/27 20:05
 * Description: 简单的集
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.holding;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleCollertion {

    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            c.add(i);  // autoboxing 自动”装箱“
        }
        for (Integer i : c) {
            System.out.println(i + " ");
        }
    }
}
