package com.code.tulip.thinking_in_java.designPatterns.singleton;

/**
 * @Classname BetterSingleton2
 * @Description 枚举形成单例（可保证线程安全，并且防止反射击穿）
 * @author codetulip
 * @Date 2019/10/23 23:40
 * @Version 1.0
 */

/**
 * enum类型是值类型，指挥加载一次，并且不能被反射获取
 */
public enum BetterSingleton2 {
    INSTANCE;

    private Singleton singleton; // 单例实例

    // 由JVM保证只会加载一次并且是线程安全的
    private BetterSingleton2() {
        singleton = new Singleton();
    }

    // 单例类
    private static class Singleton {

    }

    // 返回单例
    public Singleton getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        Singleton instance = INSTANCE.getInstance();
    }
}
