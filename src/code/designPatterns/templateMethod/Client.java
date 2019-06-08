package code.designPatterns.templateMethod;

/**
 * @Classname Client
 * @Description 场景类
 * @Author tujing
 * @Date 2019/6/8 10:33 AM
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        HummerModel hummerModel = new HummerModel1();
        // 模型演示
        hummerModel.run();
    }
}
