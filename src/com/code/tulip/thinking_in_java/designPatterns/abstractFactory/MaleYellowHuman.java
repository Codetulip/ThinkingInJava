package com.code.tulip.thinking_in_java.designPatterns.abstractFactory;

/**
 * @Classname MaleYellowHuman
 * @Description 黄人男性具体类
 * @author code-tulip
 * @Date 2019/6/1 11:13 PM
 * @Version 1.0
 */
public class MaleYellowHuman extends AbstractYellowHuman{

    // 黄人男性具体类
    @Override
    public void getSex() {
        System.out.println("黄人男性");
    }
}
