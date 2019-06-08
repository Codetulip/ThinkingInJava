package code.designPatterns.templateMethod;

/**
 * @Classname HummerModel
 * @Description 抽象模型
 * @Author tujing
 * @Date 2019/6/8 10:17 AM
 * @Version 1.0
 */
public abstract class HummerModel {
    /**
     * 首先，这个模型能够被发动起来，，这些实现都应该出现在实现类里
     */

    // 发动车辆
    public abstract void start();

    // 停止车辆
    public abstract void stop();

    // 鸣笛
    public abstract void alarm();

    // 引擎会轰轰响
    public abstract void engineBoom();

    // 车辆可以行使
    public void run() {
        // 先发动汽车
        this.start();
        // 引擎轰鸣
        this.engineBoom();
        // 车辆跑动，遇事按喇叭
        this.alarm();
        // 到达目的地后停车
        this.stop();
    }
}
