/**
 * FileName: SplitDemo
 * Author:   Code
 * Date:     2019/5/6 22:24
 * Description: 结合Splitting类看
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.strings;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SplitDemo {

    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";

        System.out.println(Arrays.toString(Pattern.compile("!!").split(input)));
        //设置偏移量
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input,3)));
    }
}
