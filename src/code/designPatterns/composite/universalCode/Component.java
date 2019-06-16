package code.designPatterns.composite.universalCode;

/**
 * @Classname Componet
 * @Description 抽象构件
 * @Author tujing
 * @Date 2019/6/16 9:09 PM
 * @Version 1.0
 */
public abstract class Component {

    // 个体和整体都具有的共享
    public void doSomething() {
        // 业务逻辑
    }

    public void setParent(Component component) {
        // 需要的节点可以覆盖实现 设置父节点 逻辑
    }
}
