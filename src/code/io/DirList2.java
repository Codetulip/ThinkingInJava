/**
 * FileName: DirList3
 * Author:   Code
 * Date:     2019/5/15 16:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {

    // 匿名内部类使用外部类参数必须是final
    // 但是现在似乎不用，在innerclasses包中已经证明过了
    public static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {

            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        File path = new File("D:\\ideaProjects\\thinkingInJava\\src");
        String[] list;
//        list = path.list(); //全部
        // 指定过滤器
        list = path.list(filter("\\D.*\\.java")); // list方法时回调accept方法
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String s : list)
            System.out.println(s);
    }
}
