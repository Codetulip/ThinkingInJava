package code.designPatterns.decorator.universalCode;

/**
 * @Classname Decorator
 * @Description
 * @Author tujing
 * @Date 2019/6/17 11:12 PM
 * @Version 1.0
 */

// 装饰模式是继承关系的一个替代方案
// 装饰模式可以动态的扩展一个实现类的功能
// 装饰模式是动态给一个对象添加一些额外的职责。就增加功能来说，装饰模式相比生成子类更为灵活。
public abstract class Decorator extends Component {

    // 定义装饰的对象
    private Component component = null;

    public Decorator(Component component) {
        this.component = component;
    }

    // 还是让被装饰对象自己执行
    public void operate() {
        this.component.operate();
    }
}
