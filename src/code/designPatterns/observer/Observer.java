package code.designPatterns.observer;

/**
 * @Interfacename Observer
 * @Description 观察者接口
 * @Author tujing
 * @Date 2019/7/6 15:12
 * @Version 1.0
 */

//java.util.Observer有接口了
public interface Observer {

    // 一旦观察到可观察对象发生变化时，行动起来
    void update(String context);
}
