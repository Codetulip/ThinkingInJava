package com.code.tulip.thinking_in_java.designPatterns.decorator;

/**
 * @Classname Decorator
 * @Description 修饰的抽象类
 * @author code-tulip
 * @Date 2019/6/17 10:56 PM
 * @Version 1.0
 */
public abstract class Decorator extends SchoolReport{

    // 声明装饰的对象
    private SchoolReport sr;

    // 传递进来装饰的对象
    public Decorator(SchoolReport sr) {
        this.sr = sr;
    }

    // 成绩单还要被看到的
    @Override
    public void report() {
        this.sr.report();
    }

    // 看完还是要签名的
    @Override
    public void sign(String name) {
        this.sr.sign(name);
    }
}
