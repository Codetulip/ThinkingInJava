package com.code.tulip.thinking_in_java.designPatterns.decorator.universalCode;

/**
 * @Classname Client
 * @Description 场景类
 * @author code-tulip
 * @Date 2019/6/17 11:16 PM
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        // 第一次装饰
        component = new ConcreteDecorator1(component);
        // 第二次装饰
        component = new ConcreteDecorator2(component);
        // 多层装饰也是装饰模式的缺点，因为比较复杂
        // 装饰后运行
        component.operate();
    }
}
