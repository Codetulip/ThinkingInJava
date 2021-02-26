package com.code.tulip.thinking_in_java.designPatterns.decorator.universalCode;

/**
 * @Classname ConcreteDecorator1
 * @Description 具体的装饰器类
 * @author code-tulip
 * @Date 2019/6/17 11:14 PM
 * @Version 1.0
 */
public class ConcreteDecorator1 extends Decorator {

    public ConcreteDecorator1(Component component) {
        super(component);
    }

    // 定义装饰的方法
    private void decorate() {
        System.out.println("装饰方法1");
    }

    // 重写父类的operate方法
    @Override
    public void operate() {
        this.decorate();
        super.operate();
    }
}
