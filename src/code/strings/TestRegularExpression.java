/**
 * FileName: TestRegularExpression
 * Author:   Code
 * Date:     2019/5/6 20:56
 * Description: Pattern和Matcher
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {

    private static String expression = "Java now has regular expression";

    public static void main(String[] args) {
        String[] regexes = {"^Java", "\\Breg.*", "n.w\\s+h(a|i)s",
                "s?", "s*", "s+", "s{4}", "s{1}.", "s{0,3}"};
        for (String regex : regexes) {
            // 编译正则表达式
            Pattern p = Pattern.compile(regex);
            // 输入要匹配的字符串
            Matcher m = p.matcher(expression);
            while (m.find()) {
                System.out.println( "正则表达式为: " + regex
                       + "  匹配到的字符串为：" + m.group() + "  位置为:" + m.start() +
                        " - " + (m.end()-1));
            }
        }
        Matcher m = Pattern.compile("\\w+").matcher(expression);
        // 如果find()中指定了搜索起点后，每次循环都将从字符串的搜索起点开始
        // 然而找到第一个group后就退出了，搜索起点固定，因此会无限循环同一个group
        // 此处可设定搜索起点后测试
        while (m.find()) {
            System.out.println(m.group() + " ");
        }
    }
}
