package code.designPatterns.abstractFactory;

/**
 * @Classname AbstractWhiteHuman
 * @Description 白色人种抽象类
 * @Author tujing
 * @Date 2019/6/1 11:07 PM
 * @Version 1.0
 */
public abstract class AbstractWhiteHuman implements Human{

    // 白色人种肤色是白色的
    public void getColor(){
        System.out.println("白色人种肤色是白色的");
    }

    // 白色人种说话
    public void talk(){
        System.out.println("白色人种会说话，一般说的是单字节");
    }
}
