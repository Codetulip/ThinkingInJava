/**
 * FileName: ExceptionLoss
 * @author:   Code
 * Date:     2019/5/5 20:36
 * Description: 异常丢失
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.exceptions;

class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "a very important exception!!";
    }
}


class HoHumException extends Exception {
    @Override
    public String toString() {
        return "a trivial exception";
    }
}

public class ExceptionLoss {

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    // 无需抛出
    void h() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        // 第一种异常丢失
        try {
            ExceptionLoss exceptionLoss = new ExceptionLoss();
            try {
                exceptionLoss.f();
            } finally {
                exceptionLoss.dispose();
            }
            // 编译器允许省略对RuntimeException的处理
            exceptionLoss.h();
        } catch (Exception e) {
            System.out.println(e);
        } // 只会产生dispose()方法抛出的异常输出
        // 第二种异常丢失
        try {
            throw new RuntimeException();
        } finally {
            // 在finally中使用return将压制抛出的异常
            return;
        } // 不会产生任何输出

    }
}
