/**
 * FileName: DirList3
 * Author:   Code
 * Date:     2019/5/15 22:01
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

public class DirList3 {

    public static void main(String[] args) {
        File path = new File("D:\\ideaProjects\\thinkingInJava\\src");
        String[] list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile("\\D.*\\.java");

            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });

        Arrays.sort(list);
        for (String s : list)
            System.out.println(s);
    }
}
