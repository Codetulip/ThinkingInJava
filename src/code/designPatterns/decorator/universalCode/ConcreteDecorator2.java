package code.designPatterns.decorator.universalCode;

/**
 * @Classname ConcreteDecorator1
 * @Description 具体的装饰器类
 * @Author tujing
 * @Date 2019/6/17 11:14 PM
 * @Version 1.0
 */
public class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    // 定义装饰的方法
    private void decorate() {
        System.out.println("装饰方法2");
    }

    // 重写父类的operate方法
    @Override
    public void operate() {
        this.decorate();
        super.operate();
    }
}
