package code.designPatterns.command;

/**
 * @Classname Receiver
 * @Description 真正接受命令的抽象类
 * @Author tujing
 * @Date 2019/7/3 8:59 PM
 * @Version 1.0
 */
public abstract class Receiver {

    // 抽象接受者，定义每个接受者都必须完成的业务
    public abstract void doSomething();
}
