package code.designPatterns.singleton;

/**
 * @Classname Singleton
 * @Description 单例模式通用代码
 * @Author tujing
 * @Date 2019/6/7 10:21 PM
 * @Version 1.0
 */
public class Singleton {

    public static final Singleton singleton = new Singleton();

    // 私有化构造器，限制产生多个对象
    private Singleton() {

    }

    // 通过公有静态方法获取该单例的实例对象
    public static Singleton getSingleton() {
        return singleton;
    }

    // 类中的其他方法，尽量是static
    public static void doSomething() {

    }
}
