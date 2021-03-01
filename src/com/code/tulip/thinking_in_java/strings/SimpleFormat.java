/**
 * FileName: SimpleFormat
 * @author:   Code
 * Date:     2019/5/6 16:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.strings;

import java.io.PrintStream;
import java.util.Formatter;

public class SimpleFormat {

    private String name ;

    private Formatter formatter;

    public SimpleFormat(String name, Formatter formatter) {
        this.name = name;
        this.formatter = formatter;
    }

    public void move(int x, int y) {
        formatter.format("%s is at (%d,%d)\n", name, x, y);
    }

    public static void main(String[] args) {
        int x = 1;
        float y = (float) 2.33;
        // 以下两个是等价的
        System.out.printf("sss : %d - %f\n", x, y); // 不会自动换行
        System.out.format("sss : %d - %f\n", x, y); // 不会自动换行

        // new Formatter()构造器接受多种输出目的地
        // 常用的是PrintStream()打印流,OutputStream输出流,File
        PrintStream p = System.out;
        SimpleFormat simpleFormat = new SimpleFormat("xixi", new Formatter(p));
        simpleFormat.move(4,8);

        // String.format()
        System.out.println(String.format("sss : %d - %f\n", x, y));
    }
}
