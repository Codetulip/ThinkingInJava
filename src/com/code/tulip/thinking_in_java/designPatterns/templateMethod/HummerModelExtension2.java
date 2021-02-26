package com.code.tulip.thinking_in_java.designPatterns.templateMethod;

/**
 * @Classname HummerModelExtension1
 * @Description 模板实现类扩展2
 * @author code-tulip
 * @Date 2019/6/8 11:09 AM
 * @Version 1.0
 */
public class HummerModelExtension2 extends HummerModelExtension {

    // 发动汽车
    @Override
    protected void start() {
        System.out.println("悍马1扩展发动...");
    }

    // 停止汽车
    @Override
    protected void stop() {
        System.out.println("悍马1扩展停车...");
    }

    // H1型号的悍马鸣笛
    @Override
    protected void alarm() {
        System.out.println("悍马1扩展鸣笛");

    }

    // 默认抹油喇叭的
    @Override
    protected boolean isAlarm() {
        return false;
    }

    // 引擎轰鸣声
    @Override
    protected void engineBoom() {
        System.out.println("悍马1扩展引擎声音是这样的...");
    }

}
