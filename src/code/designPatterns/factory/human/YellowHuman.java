package code.designPatterns.factory.human;

/**
 * @Classname YellowHuman
 * @Description
 * @Author tujing
 * @Date 2019/5/21 9:38 PM
 * @Version 1.0
 */
public class YellowHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("黄色人种皮肤是黄色的");
    }

    @Override
    public void talk() {
        System.out.println("我是黄色人种");
    }


}
