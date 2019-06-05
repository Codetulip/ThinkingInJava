package code.designPatterns.priciple.liskovSubstitutionPrinciple;

import java.util.HashMap;

/**
 * @Classname Client
 * @Description 实际上都是想执行父类定义的业务逻辑
 * @Author tujing
 * @Date 2019/6/5 1:31 PM
 * @Version 1.0
 */
public class Client {

    public static void invoke() {
        // 父类存在的地方，子类就应该能够存在
//        Father f = new Father();
        Son f = new Son(); // 此时doSomething()方法还是会调用父类的方法
        HashMap map = new HashMap();
        f.doSomething(map);
    }

    public static void main(String[] args) {
        invoke();
    }
}
