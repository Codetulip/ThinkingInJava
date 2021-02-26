package com.code.tulip.thinking_in_java.designPatterns.strategy;

/**
 * @Interfacename Strategy
 * @Description 抽象的策略角色
 * @author code-tulip
 * @Date 2019/6/30 12:28 PM
 * @Version 1.0
 */
// 定义一组算法，将每个算法都封装起来，并且使他们之间可以互换。
public interface Strategy {
    // 策略模式的运算法则
    void doSomething();
}
