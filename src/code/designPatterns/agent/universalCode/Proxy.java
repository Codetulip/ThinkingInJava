package code.designPatterns.agent.universalCode;

/**
 * @Classname Proxy
 * @Description 代理类
 * @Author tujing
 * @Date 2019/6/12 11:19 PM
 * @Version 1.0
 */
public class Proxy implements Subject {

    // 代理哪个实现类
    private Subject subject = null;

    // 默认被代理者
    public Proxy() {
        subject = new Proxy();
    }

    // 通过构造函数传递代理者
    public Proxy(Object... objects) {

    }

    // 实现接口中定义的方法
    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    // 预处理
    private void before() {
        // 预处理逻辑
    }

    // 善后处理
    private void after() {
        // 善后处理逻辑
    }
}
