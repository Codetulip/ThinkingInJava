package code.designPatterns.observer.universalCode;

import java.util.Vector;

/**
 * @Classname Subject
 * @Description 被观察者
 * @Author codetulip
 * @Date 2019/7/6 15:17
 * @Version 1.0
 */
public abstract class Subject {

    // 定义一个观察者数组
    private Vector<Observer> observers = new Vector<Observer>();

    // 增加一个观察者
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    // 删除一个观察者
    public void deleteObserver(Observer observer) {
        this.observers.remove(observer);
    }

    // 通知所有观察者
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
