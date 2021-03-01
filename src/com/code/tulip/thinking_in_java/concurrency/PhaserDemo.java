package com.code.tulip.thinking_in_java.concurrency;

import java.util.concurrent.Phaser;

/**
 * @Classname PhaserTest
 * @Description Phaser测试，类似CountDownLatch和CyclicBarrier，升级版
 * @author codetulip
 * @Date 2019/11/8 21:07
 * @Version 1.0
 */
public class PhaserDemo {

    static MarriagePhaser phaser = new MarriagePhaser();

    /**
     * 自定义行为的Phaser
     */
    static class MarriagePhaser extends Phaser {
        // 在栅栏被推倒的时候自动触发,一起向前走
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人都到齐了!" + registeredParties);
                    return false;
                case 1:
                    System.out.println("所有人都吃玩了！" + registeredParties);
                    return false;
                case 2:
                    System.out.println("所有人都离开了！" + registeredParties);
                    return false;
                case 3:
                    System.out.println("婚礼结束，新郎新娘拥抱！" + registeredParties);
                    return true;
                default:
                    return true;
            }
        }
    }

    static class Person implements Runnable {
        String name;

        Person(String name) {
            this.name = name;
        }

        public void arrive() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s到底现场!\n", name);
            phaser.arriveAndAwaitAdvance(); // 等待前进
        }

        public void eat() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s吃完了\n", name);
            phaser.arriveAndAwaitAdvance(); // 等待前进
        }

        public void leave() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s离开了\n", name);
            phaser.arriveAndAwaitAdvance(); // 等待前进
        }

        public void hug() {
            if (name.equals("新郎") || name.equals("新娘")) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s互相拥抱\n", name);
                phaser.arriveAndAwaitAdvance(); // 等待前进
            } else {
                phaser.arriveAndDeregister(); // 到底之后并减少线程个数
//                phaser.register();// 加入一个线程
            }
        }

        @Override
        public void run() {
            arrive();

            eat();

            leave();

            hug();
        }
    }

    public static void main(String[] args) {
        // 指定Phaser内部个数
        phaser.bulkRegister(7);

        for (int i = 0; i < 5; i++) {
            new Thread(new Person(i + 1 + "")).start();
        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();
    }

}

