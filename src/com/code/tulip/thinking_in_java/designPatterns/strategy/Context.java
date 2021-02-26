package com.code.tulip.thinking_in_java.designPatterns.strategy;

/**
 * @Classname Context
 * @Description 封装角色
 * @author code-tulip
 * @Date 2019/6/30 12:30 PM
 * @Version 1.0
 */
public class Context {

    // 抽象策略
    private Strategy strategy = null;

    // 构造函数设置具体策略
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    // 封装后的策略方法
    public void doAnything() {
        this.strategy.doSomething();
    }
}
