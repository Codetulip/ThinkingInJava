package com.code.tulip.thinking_in_java.designPatterns.abstractFactory;

/**
 * @Classname AbstractYellowHuman
 * @Description 黄色人种抽象类
 * @author code-tulip
 * @Date 2019/6/1 11:11 PM
 * @Version 1.0
 */
public abstract class AbstractYellowHuman implements Human {

    // 黄色人种肤色是黄色的
    @Override
    public void getColor(){
        System.out.println("黄色人种肤色是黄色的");
    }

    // 黄色人种说话
    @Override
    public void talk(){
        System.out.println("黄色人种会说话，一般说的是双字节");
    }
}
