package code.designPatterns.builder;

import java.util.ArrayList;

/**
 * @Classname CarBuilder
 * @Description 抽象汽车组装者
 * @Author tujing
 * @Date 2019/6/11 12:05 AM
 * @Version 1.0
 */
public abstract class CarBuilder {

    // 建造一个模型，你要给我提供顺序，就是组装顺序
    public abstract void setSequence(ArrayList<String> sequence);

    // 设置完毕顺序后，就可以直接拿到这个车辆模型
    public abstract CarModel getCarModel();
}
