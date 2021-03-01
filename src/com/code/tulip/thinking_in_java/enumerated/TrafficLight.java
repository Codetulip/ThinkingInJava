package com.code.tulip.thinking_in_java.enumerated;

/**
 * @Classname TrafficLight
 * @Description 使用enum作为switch的case
 * @author code-tulip
 * @Date 2019/5/23 4:56 PM
 * @Version 1.0
 */

enum Signal {
    RED, GREEN, YELLOW
}

public class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
                default:
                    System.out.println("输如错误");
        }
    }

    @Override
    public String toString() {
        return "the trafficLight is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 5; i++) {
            t.change();
            System.out.println(t);
        }
    }
}
