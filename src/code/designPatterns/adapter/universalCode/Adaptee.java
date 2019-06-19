package code.designPatterns.adapter.universalCode;

/**
 * @Classname Adaptee
 * @Description 源角色（通过适配转换为目标角色）
 * @Author tujing
 * @Date 2019/6/19 9:57 PM
 * @Version 1.0
 */
public class Adaptee {

    // 原有的业务逻辑
    public void doSomething() {
        System.out.println("I am kind of busy, leave me alont, please");
    }
}
