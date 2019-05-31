/**
 * FileName: Statistics
 * Author:   Code
 * Date:     2019/4/28 13:49
 * Description: map测试随机性
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.holding;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Statistics {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10000; i++) {
            Integer temp = rand.nextInt(20);
            Integer temp1 = map.get(temp);
            map.put(temp, (temp1 == null ? 1 : temp1 + 1));
        }
        System.out.println(map);

    }
}
