package com.code.tulip.thinking_in_java.designPatterns.strategy;

/**
 * @Classname ConcreteStrategy1
 * @Description 具体策略角色
 * @author code-tulip
 * @Date 2019/6/30 12:30 PM
 * @Version 1.0
 */
public class ConcreteStrategy1 implements Strategy {
    // 运算法则
    @Override
    public void doSomething() {
        System.out.println("决堤策略1的运算法则");
    }
}
