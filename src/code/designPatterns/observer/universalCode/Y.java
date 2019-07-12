package code.designPatterns.observer.universalCode;

import java.util.Observable;
import java.util.Observer;

/**
 * @Classname Y
 * @Description 观察者
 * @Author codetulip
 * @Date 2019/7/6 16:07
 * @Version 1.0
 */
public class Y implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("收到改变了" + arg);
    }
}
