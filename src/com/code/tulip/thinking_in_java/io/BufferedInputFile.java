/**
 * FileName: BufferedInputFile
 * @author:   Code
 * Date:     2019/5/16 15:11
 * Description: 缓冲输入文件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class BufferedInputFile {

    public static String read(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        // readLine()方法会将文件中的\n删掉
        while ((s = br.readLine()) != null) {
            sb.append(s + "\n");
        }
        br.close();
        return sb.toString();
    }

    // 18.6.1练习7
    // 从尾到头输出文件的内容
    public static String read2(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String s;
        // 存放文件中的内容
        LinkedList<String> list = new LinkedList<String>();
        while ((s = br.readLine()) != null) {
            list.add(s);
        }
        br.close();
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (String s1 : list) {
            sb.append(s1 + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(read("D:\\ideaProjects\\thinkingInJava\\src\\code\\io\\BufferedInputFile.java"));
        System.out.println(read2("D:\\ideaProjects\\thinkingInJava\\src\\code\\io\\BufferedInputFile.java"));
    }
}
