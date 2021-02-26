/**
 * FileName: IntegerMatch
 * @author:   Code
 * Date:     2019/5/6 19:47
 * Description: 正则表达式的简单应用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.strings;

public class IntegerMatch {

    public static void main(String[] args) {
        // \ 表示其后的字符具有特殊意义  ? 表示0个或者1个  \d表示整数
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
        // \\输出的即是 \
        System.out.println("\\");
    }
}
