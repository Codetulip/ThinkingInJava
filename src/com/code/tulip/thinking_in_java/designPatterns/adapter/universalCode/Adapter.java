package com.code.tulip.thinking_in_java.designPatterns.adapter.universalCode;

/**
 * @Classname Adapter
 * @Description 适配类
 * @author code-tulip
 * @Date 2019/6/19 9:59 PM
 * @Version 1.0
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.doSomething();
    }
}
