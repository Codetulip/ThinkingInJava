package code.designPatterns.factory.human;

/**
 * @Classname WhiteHuman
 * @Description
 * @Author tujing
 * @Date 2019/5/21 9:36 PM
 * @Version 1.0
 */
public class WhiteHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("白色人种皮肤是白色的");
    }

    @Override
    public void talk() {
        System.out.println("我是白色人种");
    }

}
