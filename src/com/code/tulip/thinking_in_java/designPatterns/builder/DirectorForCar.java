package com.code.tulip.thinking_in_java.designPatterns.builder;

import java.util.ArrayList;

/**
 * @Classname Director
 * @Description 导演类（建造者的管理者）
 * @author code-tulip
 * @Date 2019/6/11 12:15 AM
 * @Version 1.0
 */
// 封装组装顺序
public class DirectorForCar {

    private ArrayList<String> sequence = new ArrayList<String>();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BMWBuilder bmwBuilder = new BMWBuilder();

    /**
     * A类型奔驰车模型，组装顺序为start,stop
     */
    public BenzModel getABenzModel() {
        // 首先清空顺序
        this.sequence.clear();
        // 设置A类奔驰车组装顺序
        sequence.add("start");
        sequence.add("stop");
        this.benzBuilder.setSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    /**
     * B类奔驰车模型，组装顺序为engine boom,start,stop
     */
    public BenzModel getBBenzModel() {
        // 首先清空顺序
        this.sequence.clear();
        // 设置B类奔驰车组装顺序
        sequence.add("engine boom");
        sequence.add("start");
        sequence.add("stop");
        this.benzBuilder.setSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    /**
     * C类宝马车模型，组装顺序为alarm,start,stop
     */
    public BMWModel getCBMWModel() {
        // 首先清空顺序
        this.sequence.clear();
        // 设置C类奔驰车组装顺序
        sequence.add("alarm");
        sequence.add("start");
        sequence.add("stop");
        this.bmwBuilder.setSequence(this.sequence);
        return (BMWModel) this.bmwBuilder.getCarModel();
    }

    /**
     * D类宝马车模型，组装顺序为start
     */
    public BMWModel getDBMWModel() {
        // 首先清空顺序
        this.sequence.clear();
        // 设置D类奔驰车组装顺序
        sequence.add("start");
        this.bmwBuilder.setSequence(this.sequence);
        return (BMWModel) this.bmwBuilder.getCarModel();
    }

}
