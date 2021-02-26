package com.code.tulip.thinking_in_java.designPatterns.abstractFactory;

/**
 * @Classname FemaleYellowHuman
 * @Description 黄人女性具体类
 * @author code-tulip
 * @Date 2019/6/1 11:12 PM
 * @Version 1.0
 */
public class FemaleYellowHuman extends AbstractYellowHuman {

    // 黄人女性
    @Override
    public void getSex() {
        System.out.println("黄人女性");
    }
}
