package code.designPatterns.abstractFactory;

/**
 * @Classname NvWa
 * @Description 工厂的管理者
 * @Author tujing
 * @Date 2019/6/1 11:20 PM
 * @Version 1.0
 */
public class NvWa {

    public static void main(String[] args) {

        // 生产男性的工厂
        HumanFactory factory1 = new MaleHumanFactory();

        // 生产女性的工厂
        HumanFactory factory2 = new FemaleHumanFactory();

        // 开始生产
        Human maleYellowHuman = factory1.createYellowHuman();
        Human femaleYellowHuman = factory2.createYellowHuman();

        // 测试其中方法
        System.out.println("男性黄种人:");
        maleYellowHuman.getColor();
        maleYellowHuman.getSex();
        maleYellowHuman.talk();
        System.out.println("女性黄种人:");
        femaleYellowHuman.getColor();
        femaleYellowHuman.getSex();
        femaleYellowHuman.talk();

    }
}
