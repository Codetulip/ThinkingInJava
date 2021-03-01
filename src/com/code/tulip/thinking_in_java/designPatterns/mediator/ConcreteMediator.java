package com.code.tulip.thinking_in_java.designPatterns.mediator;

/**
 * @Classname ConcreteMediator
 * @Description 通用中介者
 * @author code-tulip
 * @Date 2019/6/30 2:37 PM
 * @Version 1.0
 */
public class ConcreteMediator extends Mediator {
    @Override
    public void doSomething1() {
        super.c1.selfMethod1();
        super.c2.selfMethod2();
    }

    @Override
    public void doSomething2() {
        super.c1.selfMethod1();
        super.c2.selfMethod2();
    }
}
