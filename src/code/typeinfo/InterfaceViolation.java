/**
 * FileName: InterfaceViolation
 * Author:   Code
 * Date:     2019/5/8 20:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.typeinfo;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

class B implements A {
    @Override
    public void f() {

    }

    public void g() {
        System.out.println("g()");
    }
}

public class InterfaceViolation {

    // 只提供包访问权限
    // 这样在包外无法向下转型为B，因为包外没有B类型
    // 因此无法调用A接口外的方法
    public static A makeA() {
        return new B();
    }

    // 但是反射方法依然允许我们调用B的g方法
    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method m = a.getClass().getDeclaredMethod(methodName);
        //值为 true 则指示反射的对象在使用时应该取消Java 语言访问检查。
        // 值为 false 则指示反射的对象应该实施 Java 语言访问检查。
        m.setAccessible(true); // 如果为false还是要进行检查则会发现g方法是不可用的，因此报错
        m.invoke(a);
        //这样即使在其他包中也可以调用g方法
        //即使是Private方法也可以调用
        //私有内部类，匿名内部类都可以调用
    }

    static void readHiddenField(Object a, String fieldName) throws Exception {
        Field f = a.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        f.getInt(a);
        f.setInt(a, 5); // 只有final在此处修改是安全的，不抛出异常，但是也不做修改
    }

    public static void main(String[] args) {
        A a = new B();
        a.f();
//        ((B) a).g();
//        a.g(); // 会报错
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B) a;
            b.g();
        }
     }
}
