package code.designPatterns.factory.human;

/**
 * @Classname HumanFactory
 * @Description 一般性的工厂模式
 * @Author tujing
 * @Date 2019/5/21 9:42 PM
 * @Version 1.0
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        // 定义一个生产的人种
        Human human = null;
        try {
//            human = c.newInstance(); // 目前使用这种方式没有问题
            // 根据传入的Class生产特定的人种
            human = (T) Class.forName(c.getName()).newInstance(); // T换成Human也可以 类必须带有默认构造器才可使用newInstance
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) human;

    }
}
