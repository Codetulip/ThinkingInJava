/**
 * FileName: NeverCaught
 * @author:   Code
 * Date:     2019/5/5 19:51
 * Description: RuntimeException不被捕获
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.exceptions;

public class NeverCaught {

    // 从头到尾RuntimeException都没有被捕获，但是运行就会出错
    // RuntimeException代表的编程错误
    static void f() {
        throw new RuntimeException();
    }

    // 编译器也不会要求你使用try/catch或者抛出
    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }

}
