package com.code.tulip.thinking_in_java.innerclasses;

/**
 * @Classname StaticClass
 * @Description
 * @author code-tulip
 * @Date 2019/5/24 1:06 PM
 * @Version 1.0
 */
public class StaticClass {

    private int i = 0;

    static class Xixi {

        void hello() {
        }
    }

    class Haha {
        // 内部类不允许有静态方法，除非是静态内部类
        /*static*/ void hello() {
        }
    }

    public static void hello(int i) {
        // 静态方法中不能直接使用类中的非静态变量
        // 可以通过参数传入
    }

    public static void main(String[] args) {
        Xixi xixi = new Xixi();
        xixi.hello();
    }
}
