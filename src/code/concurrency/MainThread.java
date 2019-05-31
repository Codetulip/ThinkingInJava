package code.concurrency;

/**
 * @Classname MainThread
 * @Description 于LiftOff结合测试
 * @Author tujing
 * @Date 2019/5/27 2:24 PM
 * @Version 1.0
 */
public class MainThread {

    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
