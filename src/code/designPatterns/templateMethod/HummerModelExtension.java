package code.designPatterns.templateMethod;

/**
 * @Classname HummerModelExtention
 * @Description 模板方法扩展
 * @Author tujing
 * @Date 2019/6/8 11:04 AM
 * @Version 1.0
 */
public abstract class HummerModelExtension {

    // 基本方法保持protected(迪米特法则)
    // 发动车辆
    protected abstract void start();

    // 停止车辆
    protected abstract void stop();

    // 鸣笛
    protected abstract void alarm();

    // 引擎会轰轰响
    protected abstract void engineBoom();

    // 车辆可以行使
    // 模板方法尽量final  防止恶心操作
    final public void run() {
        // 先发动汽车
        this.start();
        // 引擎轰鸣
        this.engineBoom();
        // 车辆跑动，遇事按喇叭
        if (this.isAlarm())
            this.alarm();
        // 到达目的地后停车
        this.stop();
    }

    // 钩子方法，默认喇叭是会响的(钩子方法模板方法才算完美)
    protected boolean isAlarm() {
        return true;
    }
}
