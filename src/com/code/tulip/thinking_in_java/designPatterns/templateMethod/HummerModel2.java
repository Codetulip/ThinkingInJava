package com.code.tulip.thinking_in_java.designPatterns.templateMethod;

/**
 * @Classname HummerModel2
 * @Description 模型实现类2
 * @author code-tulip
 * @Date 2019/6/8 10:27 AM
 * @Version 1.0
 */
public class HummerModel2 extends HummerModel{

    // 发动汽车
    @Override
    public void start() {
        System.out.println("悍马2发动...");
    }

    // 停止汽车
    @Override
    public void stop() {
        System.out.println("悍马2停车...");
    }

    // H1型号的悍马鸣笛
    @Override
    public void alarm() {
        System.out.println("悍马2鸣笛");

    }

    // 引擎轰鸣声
    @Override
    public void engineBoom() {
        System.out.println("悍马2引擎声音是这样的...");
    }

    /* 此方法完全一样，应封装起来
    // 开动起来
    public void run() {
        // 先发动汽车
        this.start();
        // 引擎轰鸣
        this.engineBoom();
        // 车辆跑动，遇事按喇叭
        this.alarm();
        // 到达目的地后停车
        this.stop();
    }*/
}
