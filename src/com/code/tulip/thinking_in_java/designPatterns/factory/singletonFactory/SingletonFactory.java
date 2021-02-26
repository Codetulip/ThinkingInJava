package com.code.tulip.thinking_in_java.designPatterns.factory.singletonFactory;

import java.lang.reflect.Constructor;

/**
 * @Classname SingletonFactory
 * @Description 利用反射创建单例
 * @author code-tulip
 * @Date 2019/5/22 12:06 AM
 * @Version 1.0
 */
public class SingletonFactory {

    private static Singleton singleton;

    static {
        try {
            Class c = Class.forName(Singleton.class.getName());
            // 获取无参构造器
            Constructor constructor = c.getDeclaredConstructor();
            // 将构造器设置为可访问的
            constructor.setAccessible(true);
            // 产生一个实例对象
            singleton = (Singleton) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 静态方法中只能使用静态变量
    public static Singleton getSingleton() {
        return singleton;
    }
}
