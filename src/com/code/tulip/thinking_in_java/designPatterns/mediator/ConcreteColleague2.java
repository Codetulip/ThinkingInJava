package com.code.tulip.thinking_in_java.designPatterns.mediator;

/**
 * @Classname ConcreteColleague1
 * @Description
 * @author code-tulip
 * @Date 2019/6/30 2:35 PM
 * @Version 1.0
 */
public class ConcreteColleague2 extends Colleague {

    // 通过构造函数传递中介者
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    // 自有方法
    public void selfMethod2() {
        // 处理自己的业务逻辑
    }

    // 依赖方法
    public void depMethod2() {
        super.mediator.doSomething2();
    }
}
