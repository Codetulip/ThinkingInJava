package code.designPatterns.abstractFactory;

/**
 * @Classname AbstractBlackHuman
 * @Description 黑色人种抽象类
 * @Author tujing
 * @Date 2019/6/1 11:09 PM
 * @Version 1.0
 */
public abstract class AbstractBlackHuman implements Human{

    // 黑色人种肤色是黑色的
    public void getColor(){
        System.out.println("黑色人种肤色是黑色的");
    }

    // 黑色人种说话
    public void talk(){
        System.out.println("黑色人种会说话，一般听不懂");
    }
}
