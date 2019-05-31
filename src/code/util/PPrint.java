/**
 * FileName: PPrint
 * Author:   Code
 * Date:     2019/5/15 23:18
 * Description: 规范输出Collection和Array
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.util;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {

    public static String pformat(Collection<?> c) {
        if (c.size() == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (Object item : c) {
            if (c.size() != 1)
                sb.append("\n");
            sb.append(item);
        }
        if (c.size() != 1)
            sb.append("\n");
        sb.append("]");
        return sb.toString();
    }

    public static void pprint(Collection<?> c) {
        System.out.println(pformat(c));
    }

    public static void pprint(Object[] c) {
        System.out.println(pformat(Arrays.asList(c)));
    }
}
