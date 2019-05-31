/**
 * FileName: ChangeSystemOut
 * Author:   Code
 * Date:     2019/5/17 13:15
 * Description: 将System.out转换成PrintWriter
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.io;

import java.io.PrintWriter;

public class ChangeSystemOut {

    public static void main(String[] args) {
        // 第二个参数设为true，开启自动清空功能，否则可能看不到输出
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("hello,world!");
    }
}
