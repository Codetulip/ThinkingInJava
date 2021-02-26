package com.code.tulip.thinking_in_java.designPatterns.abstractFactory;

/**
 * @Classname AbstractWhiteHuman
 * @Description 白色人种抽象类
 * @author code-tulip
 * @Date 2019/6/1 11:07 PM
 * @Version 1.0
 */
public abstract class AbstractWhiteHuman implements Human{

    // 白色人种肤色是白色的
    @Override
    public void getColor(){
        System.out.println("白色人种肤色是白色的");
    }

    // 白色人种说话
    @Override
    public void talk(){
        System.out.println("白色人种会说话，一般说的是单字节");
    }
}
