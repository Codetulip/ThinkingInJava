package code.designPatterns.abstractFactory;

/**
 * @Classname AbstractYellowHuman
 * @Description 黄色人种抽象类
 * @Author tujing
 * @Date 2019/6/1 11:11 PM
 * @Version 1.0
 */
public abstract class AbstractYellowHuman implements Human {

    // 黄色人种肤色是黄色的
    public void getColor(){
        System.out.println("黄色人种肤色是黄色的");
    }

    // 黄色人种说话
    public void talk(){
        System.out.println("黄色人种会说话，一般说的是双字节");
    }
}