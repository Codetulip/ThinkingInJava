/**
 * FileName: ReFlags
 * @author:   Code
 * Date:     2019/5/6 22:10
 * Description: 模式标记的测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReFlags {

    public static void main(String[] args) {
        /*// 第二种模式匹配方法，第二个参数为模式标记
        Pattern.compile("\\w+", Pattern.CASE_INSENSITIVE);*/
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE |
                Pattern.MULTILINE);
        // 默认情况下，完整字符串视为整体（不考虑换行的问题）
        Matcher m = p.matcher("java has regex\nJava has regex\n" +
                "JAVA has pretty good regular expressions\n" +
                "Regular expressions are in Java");
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
