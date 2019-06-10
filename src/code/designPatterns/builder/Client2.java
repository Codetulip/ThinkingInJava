package code.designPatterns.builder;

import java.util.ArrayList;

/**
 * @Classname Client2
 * @Description 场景类2
 * @Author tujing
 * @Date 2019/6/11 12:10 AM
 * @Version 1.0
 */
public class Client2 {

    public static void main(String[] args) {
        /**
         * 根据客户需求，提供的模型和组装顺序产生模型
         */
        // 存放组装顺序(组装顺序被写死了，可以进行封装)
        ArrayList<String> sequence = new ArrayList<String>();
        sequence.add("engine boom");
        sequence.add("start");
        sequence.add("stop");
        // 要一个奔驰车(使用建造者)
        BenzBuilder benzBuilder = new BenzBuilder();
        benzBuilder.setSequence(sequence);
        BenzModel benzModel = (BenzModel) benzBuilder.getCarModel();
        benzModel.run();
    }
}
