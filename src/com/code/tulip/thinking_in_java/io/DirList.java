/**
 * FileName: DirList
 * @author:   Code
 * Date:     2019/5/15 15:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;


// 过滤器
class DirFilter implements FilenameFilter {

    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    // dir表示路径,name表示当前过滤的文件名
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}


public class DirList {

    public static void main(String[] args) throws IOException {
        // 输入的是绝对路径
        File path = new File("D:\\ideaProjects\\thinkingInJava\\src");
        String[] list;
        list = path.list(); //全部文件和目录，返回字符串数组(数组中元素即为文件名)
        File[] files = path.listFiles(); // 全部文件和目录，返回抽象路径名数组
        // 指定过滤器
//        list = path.list(new DirFilter("\\D.*\\.java")); // list方法时回调accept方法
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }
        for (File file : files) {
            System.out.println(file); //1
            // 返回文件名
            System.out.println(file.getName());
            // 规范路径名与绝对路径名一致
            System.out.println(file.getCanonicalPath() + "\n" + file.getAbsolutePath());//2
            // 1和2中2个路径方法输出完全一样
        }
    }
}
