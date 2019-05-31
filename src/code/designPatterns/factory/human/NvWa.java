package code.designPatterns.factory.human;

/**
 * @Classname NvWa
 * @Description 负责管理工厂,即生产的管理者
 * @Author tujing
 * @Date 2019/5/21 9:55 PM
 * @Version 1.0
 */
public class NvWa {

    public static void main(String[] args) {
        HumanFactory factory = new HumanFactory();
        // 第一次
        Human human1 = factory.createHuman(WhiteHuman.class);
        human1.getColor();
        human1.talk();
        // 第二次
        Human human2 = factory.createHuman(YellowHuman.class);
        human2.getColor();
        human2.talk();
        // 第三次
        Human human3 = factory.createHuman(BlackHuman.class);
        human3.getColor();
        human3.talk();
        // 第四次（使用HumanFactory1的静态方法）静态工厂模式
        Human human4 = HumanFactory1.createHuman(BlackHuman.class);
        human4.getColor();
        human4.talk();
        // 第五次（使用多工厂模式）
        Human human5 = new YellowHumanFactory().createHuman();
        human5.getColor();
        human5.talk();

    }
}
