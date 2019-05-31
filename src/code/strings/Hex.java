/**
 * FileName: Hex
 * Author:   Code
 * Date:     2019/5/6 16:58
 * Description: 一个十六进制转储工具
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.strings;

public class Hex {

    // 十六进制转储方法
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0)
                result.append(String.format("%05X: ", n));
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 ==0)
                result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) {
//        System.out.println(format());
        System.out.println("hello");
    }
}
