package com.code.tulip.thinking_in_java.designPatterns.builder;

import java.util.ArrayList;

/**
 * @Classname CarModel
 * @Description 车辆模型的抽象类
 * @author code-tulip
 * @Date 2019/6/8 12:29 PM
 * @Version 1.0
 */
public abstract class CarModel {

    // 定义一个容器，存放基本方法的执行顺序
    private ArrayList<String> sequence = new ArrayList<String>();

    protected abstract void start();

    // 停止车辆
    protected abstract void stop();

    // 鸣笛
    protected abstract void alarm();

    // 引擎会轰轰响
    protected abstract void engineBoom();

    // 车辆可以行使
    final public void run() {
        // 根据执行顺序执行基本方法
        for (int i = 0; i < sequence.size(); i++) {
            String actionName = sequence.get(i);
            if (actionName.equalsIgnoreCase("start")) {
                this.start(); // 启动汽车
            } else if (actionName.equalsIgnoreCase("stop")) {
                this.stop(); // 停止汽车
            } else if (actionName.equalsIgnoreCase("alarm")) {
                this.alarm(); // 鸣笛
            } else if (actionName.equalsIgnoreCase("engine Boom")) {
                this.engineBoom(); // 引擎开始轰鸣
            }
        }
    }

    // 将顺序传递进来(允许客户自己定义顺序)
    final public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}
