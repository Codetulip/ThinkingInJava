package code.designPatterns.builder;

/**
 * @Classname BMWModel
 * @Description 车辆模型的具体类2
 * @Author tujing
 * @Date 2019/6/11 12:01 AM
 * @Version 1.0
 */
public class BMWModel extends CarModel {


    @Override
    protected void start() {
        System.out.println("宝马车奔跑起来..");
    }

    @Override
    protected void stop() {
        System.out.println("宝马车停下来..");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马车鸣笛..");
    }

    @Override
    protected void engineBoom() {
        System.out.println("宝马车引擎发动了..");
    }
}
