/**
 * FileName: FileOutputShortcut
 * @author:   Code
 * Date:     2019/5/16 16:02
 * Description: BasicFileOutput的快捷方式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {

    static String file = ""; // 存储输出文件路径

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("D:\\ideaProjects\\thinkingInJava\\src\\code\\io\\MemoryInput.java")));
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ +":" + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
        in.close();
    }
}
