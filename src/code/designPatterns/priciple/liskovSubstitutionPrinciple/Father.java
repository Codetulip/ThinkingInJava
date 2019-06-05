package code.designPatterns.priciple.liskovSubstitutionPrinciple;

import java.util.Collection;
import java.util.Map;

/**
 * @Classname Father
 * @Description 里式替换原则测试
 * @Author tujing
 * @Date 2019/6/5 1:26 PM
 * @Version 1.0
 */
public class Father {

    /*// point 1
    public Collection doSomething(HashMap map) {
        System.out.println("父类被执行...");
        return map.values();
    }*/

    // point 2
    public Collection doSomething(Map map) {
        System.out.println("父类被执行...");
        return map.values();
    }
}
