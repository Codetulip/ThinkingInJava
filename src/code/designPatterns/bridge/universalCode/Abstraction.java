package code.designPatterns.bridge.universalCode;

/**
 * @Classname Abstraction
 * @Description 抽象化角色
 * @Author tujing
 * @Date 2019/6/27 10:56 PM
 * @Version 1.0
 */
public abstract class Abstraction {

    private Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    // 自身行为和属性
    public void request() {
        this.implementor.doSomething();
    }

    // 获得实现化角色
    public Implementor getImpl() {
        return this.implementor;
    }
}
