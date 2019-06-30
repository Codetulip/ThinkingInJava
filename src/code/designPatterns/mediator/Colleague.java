package code.designPatterns.mediator;

/**
 * @Interfacename Colleague
 * @Description 抽象同事类
 * @Author tujing
 * @Date 2019/6/30 2:33 PM
 * @Version 1.0
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
