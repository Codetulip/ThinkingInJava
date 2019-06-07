package code.designPatterns.singleton;

/**
 * @Classname Emperor
 * @Description 单例(与Minister类关联使用)
 * @Author tujing
 * @Date 2019/6/7 10:14 PM
 * @Version 1.0
 */
public class Emperor {

    private static final Emperor emperor = new Emperor(); // 饿汉式

    private Emperor() {
        // 必须是private，这样外部类无法访问到
    }

    // 通过静态公有方法获取单例
    public static Emperor getInstance() {
        return emperor;
    }

    // 单例的某些行为
    public static/*static可有可无*/ void say() {
        System.out.println("我就是皇帝（单例）....");
    }
}
