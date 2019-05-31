/**
 * FileName: TheReplacements
 * Author:   Code
 * Date:     2019/5/7 12:57
 * Description: appendReplacement()和appendTail()的使用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheReplacements {

    public static void main(String[] args) {
        StringBuffer sbf = new StringBuffer();
        Matcher m = Pattern.compile("[aeiou]").matcher("one cat two cats " +
                "in the yards");
        System.out.println(m);
        while (m.find()) {
            m.appendReplacement(sbf, m.group().toUpperCase());
        } // 此处sbf中为：one CAT two CATS
        m.appendTail(sbf);
        // 此处为one CAT two CATS in the yards
        System.out.println(sbf);
    }
}
