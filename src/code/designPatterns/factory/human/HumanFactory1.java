package code.designPatterns.factory.human;

/**
 * @Classname HumanFactory1
 * @Description 静态工厂模式（简单工厂方法模式）
 * @Author tujing
 * @Date 2019/5/21 9:42 PM
 * @Version 1.0
 */
public class HumanFactory1 {

    public  static <T extends Human> T createHuman(Class<T> c) {
        // 定义一个生产的人种
        Human human = null;
        try {
            // 根据传入的Class生产特定的人种
            human = (T) Class.forName(c.getName()).newInstance(); // T换成Human也可以
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) human; // 此处转换成T即可

    }
}
