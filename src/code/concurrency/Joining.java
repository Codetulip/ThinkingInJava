package code.concurrency;

/**
 * @Classname Joining
 * @Description 调用join()方法
 * @Author tujing
 * @Date 2019/5/27 4:50 PM
 * @Version 1.0
 */

class Sleeper extends Thread {

    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    public void run() {
        try {
            sleep(10);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted." + "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");

    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}

public class Joining {

    public static void main(String[] args) {
        Sleeper
                sleepy = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);
        Joiner
                dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);
        // 调用这个方法将给线程设定一个标志，表示线程已经被中断了
        // 但是当异常别捕获时，将会清理这个标志，所以在catch子句中异常被捕获时这个标志总是假
        grumpy.interrupt();

    }
}
