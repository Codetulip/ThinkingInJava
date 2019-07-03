package code.designPatterns.command;

/**
 * @Classname Invoker
 * @Description 调用的Invoker类
 * @Author tujing
 * @Date 2019/7/3 9:05 PM
 * @Version 1.0
 */
public class Invoker {

    private Command command;

    // 可由构造器传入，也可以set
    public Invoker() {

    }

    public Invoker(Command command) {
        this.command = command;
    }

    // 接受命令
    public void setCommand(Command command) {
        this.command = command;
    }

    // 执行命令
    public void action() {
        this.command.execute();
    }
}
