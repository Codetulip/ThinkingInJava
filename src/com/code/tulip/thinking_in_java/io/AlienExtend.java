package com.code.tulip.thinking_in_java.io;

import java.io.Serializable;

/**
 * @Classname AlienExtend
 * @Description
 * @author code-tulip
 * @Date 2019/5/22 11:45 PM
 * @Version 1.0
 */
public class AlienExtend extends Alien implements Serializable {

    // 派生类的构造器都会隐式的调用基类的无参构造器
    public AlienExtend(int n) {
        super(n);
        System.out.println("AlienExtend 有参构造器");
    }

    // 即使基类没有无参构造器，派生依然可以有无参构造器，但是必须自己处理调用基类构造器
    public AlienExtend() {
        super(1);
        System.out.println("AlienExtend 无参构造器");
    }

}
