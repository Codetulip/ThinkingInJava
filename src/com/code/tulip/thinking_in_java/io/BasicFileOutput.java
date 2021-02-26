/**
 * FileName: BasicFileOutput
 * @author:   Code
 * Date:     2019/5/16 15:52
 * Description: 基本的文件输出
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.io;

import java.io.*;

public class BasicFileOutput {

    static String file = "C:\\Users\\Code\\Desktop\\code.txt"; // 存放文件输出路径

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("D:\\ideaProjects\\thinkingInJava\\src\\code\\io\\MemoryInput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
        in.close();
    }
}
