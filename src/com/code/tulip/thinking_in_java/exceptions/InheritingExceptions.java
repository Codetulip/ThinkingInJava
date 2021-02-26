/**
 * FileName: InheritingExceptions
 * @author:   Code
 * Date:     2019/5/5 14:22
 * Description: 异常基础代码，异常链
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.exceptions;


class SimpleException2 extends Exception {
    SimpleException2() {}
}


public class InheritingExceptions {

    public void f() throws SimpleException2 {
        System.out.println("Throw SimpleException from f()");
       throw new SimpleException2();
        // 异常链接起来，Error,Exception,RuntimeException可以直接构造器放入cause(原始异常)
        // 其他链接使用xxx.initCause()方法
//        throw new Error(new Exception());
//        throw new RuntimeException(new Exception());  // 不需要异常说明中声明方法将抛出RuntimeException
//        throw new Exception(new RuntimeException());
    }

    public static void main(String[] args) {
        InheritingExceptions ie = new InheritingExceptions();
        try {
            ie.f();
        } catch (SimpleException2 e) {
            e.printStackTrace(); //标准错误流
//            e.printStackTrace2(System.out); // 发送给标准输出流
            System.out.println("1 : " + e.getMessage());
            System.out.println("2 : " + e.getLocalizedMessage());
            System.out.println("3 : " + e.toString());
            for ( StackTraceElement stackTrace : e.getStackTrace()) {
                System.out.println(stackTrace.getMethodName());
            }
        }
        // 自定义异常使用initCause方法链接异常
        SimpleException2 simpleException = new SimpleException2();
        simpleException.initCause(new SimpleException2());
    }
}
