/**
 * FileName: CyclicBarrierDemo
 * Author:   Code
 * Date:     2019/1/29 13:07
 * Description: CyclicBarrier
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.concurrency;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Horse implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private static Random random = new Random(47);

    private int steps = 0; // 步数

    public synchronized int getSteps() {
        return steps;
    }

    private static CyclicBarrier cyclicBarrier;

    Horse(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    steps += random.nextInt(3);
                }
                // 在等待前已经获得了steps
                cyclicBarrier.await();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Horse" + id + " ";
    }

    public String tracks() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getSteps(); i++) {
            sb.append("*");
        }
        sb.append(id);
        return sb.toString();
    }

}

public class CyclicBarrierDemo {

    private static final int FINISH_LINE = 50; // 终点距离

    private List<Horse> horses = new ArrayList<>();// 存放所有线程

    private CyclicBarrier cyclicBarrier;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    CyclicBarrierDemo(int nHorses, int pause) {
        cyclicBarrier = new CyclicBarrier(nHorses, new Runnable() { // 此为屏障操作，当所有线程都完成时自动执行
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    sb.append("=");
                }
                System.out.println(sb.toString());
                for (Horse horse : horses) {
                    System.out.println(horse.tracks());
                }
                for (Horse horse : horses) {
                    if (horse.getSteps() >= FINISH_LINE) {
                        System.out.println(horse + "win!!!");
                        executorService.shutdownNow();
                        return;
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.out.println("Barriers sleep interrupted");
                }
            }
        });
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(cyclicBarrier);
            horses.add(horse);
            executorService.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 200;
        if (args.length > 0) nHorses = Integer.valueOf(args[0]) > 0 ? Integer.valueOf(args[0]) : nHorses;
        if (args.length > 1) pause = Integer.valueOf(args[1]) > -1 ? Integer.valueOf(args[1]) : pause;
        new CyclicBarrierDemo(nHorses, pause);
    }
}
