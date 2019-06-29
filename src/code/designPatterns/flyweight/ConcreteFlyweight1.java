package code.designPatterns.flyweight;

/**
 * @Classname ConcreteFlyweight1
 * @Description 具体享元角色
 * @Author tujing
 * @Date 2019/6/29 10:35 PM
 * @Version 1.0
 */
public class ConcreteFlyweight1 extends Flyweight {
    public ConcreteFlyweight1(String extrinsic) {
        super(extrinsic);
    }

    // 利用外部状态进行逻辑处理
    @Override
    public void operate() {
        // 业务逻辑
    }
}
