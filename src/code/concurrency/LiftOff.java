package code.concurrency;

/**
 * @Classname LiftOff
 * @Description 简单的定义线程任务
 * @Author tujing
 * @Date 2019/5/27 2:18 PM
 * @Version 1.0
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;  // 默认值

    private static int taskCount = 0;

    private final int id = taskCount++;

    public LiftOff() {}

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ")," ;
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield(); // 暂停当前执行的线程对象，并执行其他线程(这只是一个提示，没有任何机制保证它将会被采纳)
            // 使任务中止执行给定的时间
//            TimeUnit.MILLISECONDS.sleep(100);
        }
    }

}
