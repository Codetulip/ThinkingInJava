/**
 * FileName: OverrideTest
 * @author:   Code
 * Date:     2019/5/5 21:22
 * Description: 覆盖方法和派生类的一些测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.reusing;

import com.code.tulip.thinking_in_java.exceptions.LoggingException;
import com.code.tulip.thinking_in_java.exceptions.SimpleException;

class Parcel {

    Parcel() throws SimpleException {
    }

    protected void f() throws SimpleException, LoggingException {
    }

    public void g() throws SimpleException {}
}

class Parcel2 extends Parcel {

    private Soap soap;

    Parcel2() throws LoggingException, SimpleException {
    }

    // 覆盖父类方法时，范围修饰不能更严格，但是可以更加广泛
    // 覆盖父类方法时，抛出的异常不能更加广泛
    @Override
    public void f() throws SimpleException {
    }

    //    private void f() {}

    // 派生类方法可以不抛出任何异常，即使是基类方法中声明的
    @Override
    public void g() {}
}

public class OverrideTest {

    public static void main(String[] args) throws LoggingException, SimpleException {
        Parcel p = new Parcel2();
        // 转为基类时，还是必须要抛出异常，或者做异常处理的
        ((Parcel) p).g();

    }
}
