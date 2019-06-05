package code.designPatterns.priciple.liskovSubstitutionPrinciple;

import java.util.Collection;
import java.util.HashMap;

/**
 * @Classname Son
 * @Description
 * @Author tujing
 * @Date 2019/6/5 1:29 PM
 * @Version 1.0
 */
public class Son extends Father {

    /*// point 1
    // 放大输入参数类型
//    @Override 会出错
    public Collection doSomething(Map map) { // 重载
        System.out.println("子类被执行...");
        return map.values();
    }*/

    // point 2
    // 缩小输入参数类型
    public Collection doSomething(HashMap map) { // 重载并非覆盖
        // 子类在没有覆盖父类方法的前提下，里式替换原则要求子类写的方法是不会调用的
         // point 2这种情况下会导致子类没有覆盖父类方法，但是依然执行了
        System.out.println("子类被执行...");
        return map.values();
    }
}
