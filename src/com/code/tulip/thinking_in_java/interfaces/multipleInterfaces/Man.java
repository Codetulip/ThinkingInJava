package com.code.tulip.thinking_in_java.interfaces.multipleInterfaces;

// 接口可以多重继承
interface CanBeMan extends CanSwim,CanFly {
}

public class Man implements CanBeMan {

    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}
