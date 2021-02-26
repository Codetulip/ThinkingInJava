package com.code.tulip.thinking_in_java.designPatterns.flyweight;

/**
 * @Classname Flyweight
 * @Description 抽象享元角色
 * @author code-tulip
 * @Date 2019/6/29 10:31 PM
 * @Version 1.0
 */
public abstract class Flyweight {

    // 内部状态
    private String intrinsic;

    // 外部状态
    protected final String extrinsic;

    // 要求享元角色必须接受外部状态
    public Flyweight(String extrinsic) {
        this.extrinsic = extrinsic;
    }

    // 定义业务逻辑
    public abstract void operate();

    // 内部状态的getter/setter
    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }

}
