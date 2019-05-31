/**
 * FileName: UsingStringBuilder
 * Author:   Code
 * Date:     2019/5/6 15:42
 * Description: StringBuilder的使用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.strings;

import java.util.Random;

public class UsingStringBuilder {

    public static Random random = new Random(47);

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(random.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }


    public static void main(String[] args) throws Exception {
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb);
    }
}
