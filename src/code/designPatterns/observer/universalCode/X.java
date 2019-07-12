package code.designPatterns.observer.universalCode;

import java.util.Observable;

/**
 * @Classname X
 * @Description 被观察者
 * @Author codetulip
 * @Date 2019/7/6 16:06
 * @Version 1.0
 */
public class X extends Observable {


    public void change() {
        System.out.println("改变了");
        super.setChanged();
        super.notifyObservers("xixiix");
    }
}
