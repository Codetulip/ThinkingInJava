package code.designPatterns.builder;

/**
 * @Classname BenzModel
 * @Description 车辆模型的具体类1
 * @Author tujing
 * @Date 2019/6/8 12:36 PM
 * @Version 1.0
 */
public class BenzModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("奔驰车奔跑起来..");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰车停下来..");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰车鸣笛..");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰车引擎发动了..");
    }
}
