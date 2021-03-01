/**
 * FileName: Redirecting
 * @author:   Code
 * Date:     2019/5/17 13:18
 * Description: 标准io重定向
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.io;

import java.io.*;

//System.setIn(InputStream)、System.setOut(OutputStream)、System.setErr(OutputStream)
//IO重定向控制的是字节流  而不是字符流
public class Redirecting {

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("C:\\Users\\Code\\Desktop\\code.txt")
        );
        PrintStream out = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("C:\\Users\\Code\\Desktop\\code1.txt")
                )
        );
        // 将标准输入附接到文件上，文件上的内容(code.txt)即为标准输入
        System.setIn(in);
        // 将标准输出和标准错误重定向到文件上
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s); // 输出被重定向到了文件(code1.txt)里，因此控制台没有输出
        }
        out.close();
        System.setOut(console); // 将输出重定向回控制台
    }
}
