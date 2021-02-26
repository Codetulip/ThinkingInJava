/**
 * FileName: Directory
 * @author:   Code
 * Date:     2019/5/15 22:13
 * Description: 目录实用工具
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class Directory {

    // 直接放入File和正则表达式
    public static File[] local(File dir, String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            // accept中的参数File dir就是文件路径指定的目录或文件
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    // 参数给定为路径名和正则表达式
    public static File[] local(String path, String regex) {
        return local(new File(path), regex);
    }

    // TreeInfo存放了某目录节点下的文件和目录
    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>(); // 存放此TreeInfo下所有的文件

        public List<File> dirs = new ArrayList<File>(); // 存放此TreeInfo下所有的目录


        // Iterable后的泛型指定迭代器中存入和返回的元素类型
        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        // 此方法没有标准化，输出只占两行，一行太长
        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    /**
     * 此方法功能：从起始目录开始递归遍历整个文件夹，分别将文件和目录加入files和dirs中
     *
     * @param startDir 目录名
     * @param regex    正则表达式
     * @return 返回一个类(TreeInfo)，此类包含了指定路径文件下所有的具体文件和目录
     */
    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                // 如果是目录就加入此TreeInfo类中dirs中
                result.dirs.add(item);
                // 并且递归遍历这个目录
                result.addAll(recurseDirs(item, regex));
            } else {
                if (item.getName().matches(regex)) {
                    result.files.add(item);
                }
            }
        }
        return result;
    }

    // 重载不同的walk方法

    /**
     * 此方法作用，获取指定路径文件下的所有具体文件和目录
     *
     * @param start 路径名
     * @param regex 正则表达式
     * @return 返回一个类(TreeInfo)，此类包含了指定路径文件下所有的具体文件和目录
     */
    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    // 参数为File和正则表达式
    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    // 参数为路径名
    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    // 参数为File
    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    // 实现统计文件内容的行数
    public static int caculateLine(File file) throws IOException {
        int line = 0;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        while ((s = br.readLine()) != null) {
            line++;
        }
        br.close();

        return line;
    }

    public static void main(String[] args) throws IOException {
        int line = 0;
        TreeInfo code = walk("/Users/code/java/ideaProjects/thinkingInJava/src/", "\\w*\\.java");
        for (File file : code.files) {
            line += caculateLine(file);
        }
        System.out.println("文件数为: " + code.files.size() + "\n模糊的代码行数为: " + line);
    }
}
