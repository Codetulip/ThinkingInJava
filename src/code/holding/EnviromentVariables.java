/**
 * FileName: EnviromentVariables
 * Author:   Code
 * Date:     2019/4/28 22:57
 * Description: 操作系统环境变量
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.holding;

import java.util.Map;

public class EnviromentVariables {

    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
