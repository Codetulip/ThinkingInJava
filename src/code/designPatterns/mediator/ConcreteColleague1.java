package code.designPatterns.mediator;

/**
 * @Classname ConcreteColleague1
 * @Description
 * @Author tujing
 * @Date 2019/6/30 2:35 PM
 * @Version 1.0
 */
public class ConcreteColleague1 extends Colleague {

    // 通过构造函数传递中介者
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    // 自有方法
    public void selfMethod1() {
        // 处理自己的业务逻辑
    }

    // 依赖方法
    public void depMethod1() {
        super.mediator.doSomething1();
    }
}
