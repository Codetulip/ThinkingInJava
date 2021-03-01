package com.code.tulip.thinking_in_java.designPatterns.flyweight;

import java.util.HashMap;

/**
 * @Classname FlyweightFactory
 * @Description 享元工厂
 * @author code-tulip
 * @Date 2019/6/29 10:37 PM
 * @Version 1.0
 */
// 有线程安全问题
public class FlyweightFactory {

    // 定义一个池容器
    private static HashMap<String, Flyweight> pool = new HashMap<>();

    // 享元工厂
    public static Flyweight getFlyweight(String extrinsic) {
        // 需要返回的对象
        Flyweight flyweight = null;
        // 在池中没有该对象
        if (!pool.containsKey(extrinsic)) {
            // 根据外部状态创建享元对象
            flyweight = new ConcreteFlyweight1(extrinsic);
            // 放置到池中
            pool.put(extrinsic, flyweight);
        } else {
            flyweight = pool.get(extrinsic);
        }
        return flyweight;
    }
}
