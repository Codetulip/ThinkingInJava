/**
 * FileName: Parcel3
 * @author:   Code
 * Date:     2019/4/25 15:30
 * Description: 内部类的不同形式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.innerclasses;

import java.lang.reflect.InvocationTargetException;

public class Parcel3 {

    // 某作用域内内部类
    public void hello(boolean b) {

        if (b) {
            // 某个作用域内的内部类
            class InnerClass {
                public void hello() {
                }
            }

            InnerClass innerClass = new InnerClass();
            innerClass.hello();
        } else {
            System.out.println("nothing");
        }
    }

    // 方法内内部类/局部内部类
    public Destination destination(String s) {
        // 方法内的内部类，方法外无法使用
        class PDestination implements Destination {
            PDestination() {
                System.out.println("PDestination newing...");
            } // 带名字的构造器
        }

        return new PDestination();
    }

    // 匿名内部类
    // 意思是创建一个继承自Contents的匿名内部类
    // 即如果接口（或类）Contents本身不存在，这么写会报错
    // 匿名内部类使用外部对象必须是final
    public Contents contents(final String value) { // 不写final，并没有报错，而且结果正确 ???
        return new Contents(){
            {
                // 通过实例化的人工构造器
                System.out.println("Contents newing....");
            }
            private String i = value;

            @Override
            public String value() {
                return i;
            }

            public void hello() {
                System.out.println("hello");
            }
        };
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Parcel3 p = new Parcel3();
        Contents c = p.contents("haha");
     /*   //利用反射还是调用得到hello()方法的
        Method m = c.getClass().getDeclaredMethod("hello");
        m.setAccessible(true);
        m.invoke(c);*/
        for (int i =0; i < 5; i++) {
            System.out.println(c.value());
        }
        for (int i =0; i < 5; i++) {
            System.out.println(p.contents("hehe").value());
        }
    }

}
