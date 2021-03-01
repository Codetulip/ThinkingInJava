package com.code.tulip.thinking_in_java.designPatterns.mediator;

/**
 * @Interfacename Colleague
 * @Description 抽象同事类
 * @author code-tulip
 * @Date 2019/6/30 2:33 PM
 * @Version 1.0
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
