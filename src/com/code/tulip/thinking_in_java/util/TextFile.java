/**
 * FileName: TextFile
 * @author:   Code
 * Date:     2019/5/16 22:07
 * Description: 读写文件工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFile extends ArrayList<String> {

    /**
     * 读取文件内容并以字符串的形式返回
     * @param filename 文件路径名
     * @return 文件内容字符串
     */
    public static String read(String filename) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(new File(filename).getAbsoluteFile())
            );
            try {
                String s;
                while ((s = br.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    /**
     * 将指定内容写入指定文件中
     * @param filename 文件路径名
     * @param text 写入的内容
     */
    public static void write(String filename, String text) {
        try {
            // PrintWriter out = new PrintWriter(filename);
            PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile());
            try {
                //此处输出将text内容中的\n去掉了
//                out.write(text); // write方法为直接覆盖写入（即删除原有的重新写入指定内容）
                out.print(text); // print方法类似write方法，也是覆盖写入
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String filename, String splitter) {
        // 将文件内容转换到list中
        super(Arrays.asList(read(filename).split(splitter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }

    public TextFile(String filename) {
        this(filename, "\n");
    }

    /**
     * 将TextFile内容写入指定文件中
     * @param filename 指定写入文件路径名
     */
    public void write(String filename) {
        try {
            PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile());
            try {
                for (String s : this) {
                    out.println(s);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read("C:\\Users\\Code\\Desktop\\code.txt");
        write("C:\\Users\\Code\\Desktop\\code1.txt", file);

        TextFile textFile = new TextFile("C:\\Users\\Code\\Desktop\\code.txt");
        textFile.write("C:\\Users\\Code\\Desktop\\code1.txt");

        System.out.println(textFile);
    }
}
