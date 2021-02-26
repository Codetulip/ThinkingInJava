package com.code.tulip.thinking_in_java.designPatterns.observer;


/**
 * @Classname Observable
 * @Description 被观察者接口
 * @author codetulip
 * @Date 2019/7/6 15:09
 * @Version 1.0
 */

//java.util.Observable有接口了
public interface Observable {

    // 增加一个观察者
    void addObserver(Observer observer);

    // 删除一个观察者
    void deleteObserver(Observer observer);

    // 通知观察者
    void notifyObservers(String context);
}
