/**
 * FileName: Echo
 * Author:   Code
 * Date:     2019/5/17 13:08
 * Description: 从标准输入中读取
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// System.in是没有经过包装的InputStream对象，
// 因此在读取System.in之前应该对其包装
public class Echo {

    public static void main(String[] args) throws IOException {
        // InputStreamReader可以将InputStream转换为Reader
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0)
            System.out.println(s);
    }
}
