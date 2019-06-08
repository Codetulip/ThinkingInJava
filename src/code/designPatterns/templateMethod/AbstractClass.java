package code.designPatterns.templateMethod;

/**
 * @Classname AbstractClass
 * @Description 抽象模板类
 * @Author tujing
 * @Date 2019/6/8 10:37 AM
 * @Version 1.0
 */
public abstract class AbstractClass {

    // 基本方法
    public abstract void doSomething();

    // 基本方法
    public abstract void doAnything();

    // 模板方法
    public void templateMethod() {
        /**
         * 调用基本方法，完成相关的逻辑
         */
        this.doSomething();
        this.doAnything();
    }
}
