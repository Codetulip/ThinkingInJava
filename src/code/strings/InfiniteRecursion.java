/**
 * FileName: InfiniteRecursion
 * Author:   Code
 * Date:     2019/5/6 15:55
 * Description: 无意识的递归
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.strings;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {

    public String toString() {
        // 这个this指代类本身，因此还会被转义为字符串调用toString()方法，而并不是产生了类地址
        // 此时如果需要产生地址，需要调用基类的toString()方法
//        return "InfiniteRecursion address : + " + this + "\n";
        return "InfiniteRecursion address : + " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> list = new ArrayList<InfiniteRecursion>();
        for (int i = 0; i < 10; i++) {
            list.add(new InfiniteRecursion());
        }
        System.out.println(list);

    }
}
