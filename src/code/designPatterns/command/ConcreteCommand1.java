package code.designPatterns.command;

/**
 * @Classname ConcreteCommand1
 * @Description 具体的Command类
 * @Author tujing
 * @Date 2019/7/3 9:03 PM
 * @Version 1.0
 */
public class ConcreteCommand1 extends Command{

    // 由哪个receiver类进行命令处理
    private Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        // 业务处理
        this.receiver.doSomething();
    }
}
