package code.designPatterns.builder;

import java.util.ArrayList;

/**
 * @Classname Client1
 * @Description 场景类1
 * @Author tujing
 * @Date 2019/6/11 12:01 AM
 * @Version 1.0
 */
public class Client1 {

    public static void main(String[] args) {
        /**
         * 客户需求，需要一个这样的模型，模型有这样的顺序
         */
        BenzModel benzModel = new BenzModel();
        // 存放run顺序
        ArrayList<String> sequence = new ArrayList<String>();
        // 客户需求的顺序
        sequence.add("engine boom");
        sequence.add("start");
        sequence.add("stop");
        benzModel.setSequence(sequence);
        benzModel.run();
    }
}
