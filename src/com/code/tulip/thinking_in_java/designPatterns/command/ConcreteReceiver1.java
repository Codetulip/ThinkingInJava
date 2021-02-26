package com.code.tulip.thinking_in_java.designPatterns.command;

/**
 * @Classname ConcreteReceiver1
 * @Description 具体的receiver类
 * @author code-tulip
 * @Date 2019/7/3 9:01 PM
 * @Version 1.0
 */
public class ConcreteReceiver1 extends Receiver{

    // 每个接收者必须处理一定的业务逻辑
    @Override
    public void doSomething() {
        // 业务逻辑
    }
}
