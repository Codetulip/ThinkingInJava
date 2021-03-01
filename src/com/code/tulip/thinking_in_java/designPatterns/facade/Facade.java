package com.code.tulip.thinking_in_java.designPatterns.facade;

/**
 * @Classname Facade
 * @Description
 * @author code-tulip
 * @Date 2019/6/29 9:53 PM
 * @Version 1.0
 */
// 门面模式
public class Facade {

    // 被委托的对象
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();

    public void methodA() {
        this.a.doSomethingA();
    }

    public void methodB() {
        this.b.doSomethingB();
    }
}
