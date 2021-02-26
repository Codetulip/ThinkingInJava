package com.code.tulip.thinking_in_java.designPatterns.templateMethod;

/**
 * @Classname HummerModelExtension1
 * @Description 模板实现类扩展1
 * @author code-tulip
 * @Date 2019/6/8 11:09 AM
 * @Version 1.0
 */
public class HummerModelExtension1 extends HummerModelExtension {

    private boolean alarmFlag = true; // 标志位，要响喇叭

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

    @Override
    protected boolean isAlarm() {
        return this.alarmFlag;
    }

    // 引擎轰鸣声
    @Override
    protected void engineBoom() {
        System.out.println("悍马1扩展引擎声音是这样的...");
    }

    // 要不要响喇叭，由客户决定
    public void setAlarmFlag(boolean isAlarm) {
        this.alarmFlag = isAlarm;
    }
}
